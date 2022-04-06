package com.shop.shopping.controller;

import com.shop.shopping.dto.requests.RoleRequest;
import com.shop.shopping.dto.response.RoleResponse;
import com.shop.shopping.model.role.Roles;
import com.shop.shopping.services.services.RoleServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {


    private final RoleServiceInt roleService;

    @PostMapping("/add")
    public ResponseEntity<Roles> addRole(@RequestBody RoleRequest request) {
        return ResponseEntity.ok(roleService.addRole(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Roles>> getAll(Pageable pageable) {
        return ResponseEntity.ok(roleService.getAll(pageable));
    }

    @PostMapping("/getById/{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable Long id) {
        Roles role = roleService.getById(id);
        return ResponseEntity.ok(this.convertToResponse(role));
    }

    private RoleResponse convertToResponse(Roles role) {
        return RoleResponse.RuleResponseBuilder.builder()
                .setId(role.getId())
                .setName(role.getName())
                .setPersianName(role.getPersianName())
                .build();
    }

}
