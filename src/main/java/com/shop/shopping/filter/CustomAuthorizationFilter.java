package com.shop.shopping.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getParameter("password") == null || request.getParameter("username") == null){
            this.objectMapper(request, response);
        }
        if (request.getServletPath().equals("/api/login") || request.getServletPath().equals("/api/token/refresh/**")){
            filterChain.doFilter(request,response);
            Map<String ,String > error = new HashMap<>();
            error.put("error","Unauthorized");

            new ObjectMapper().writeValue(response.getOutputStream(), error);
        }
        else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                try {
                    String token  = authorizationHeader.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);
                    String username = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    stream(roles).forEach(role ->{
                        authorities.add(new SimpleGrantedAuthority(role));
                    });
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } catch (Exception exception){
                    log.error("Error logging in {}", exception.getMessage());
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                    Map<String ,String > error = new HashMap<>();
                    error.put("error_message", exception.getMessage());
                    error.put("error_code", FORBIDDEN.value()+"");
                    error.put("date", new Date().toString());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);

                }
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }
    private ObjectMapper objectMapper(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String ,String> error = new HashMap<>();
        error.put("date", new Date().toString());
        ObjectMapper objectMapper = new ObjectMapper();
        response.setStatus(FORBIDDEN.value());
        response.setContentType(APPLICATION_JSON_VALUE);
        error.put("status", HttpStatus.UNAUTHORIZED.toString());

        if (request.getParameter("username") == null){
            error.put("error_message", "Username is required");
            objectMapper.writeValue(response.getOutputStream(), error);
        }
        if (request.getParameter("password") == null){
            error.put("error_message", "Password is required");
            objectMapper.writeValue(response.getOutputStream(), error);
        }
        return objectMapper;

    }
}
