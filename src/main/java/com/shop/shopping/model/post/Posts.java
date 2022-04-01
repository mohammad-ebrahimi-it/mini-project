package com.shop.shopping.model.post;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.shop.shopping.model.user.Users;
import com.shop.shopping.model.category.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String cover;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime CreatedAt;

    @CreationTimestamp
    private LocalDateTime UpdateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToMany
    @JoinTable(name = "post_category", joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Categories> categories = new HashSet<>();

}
