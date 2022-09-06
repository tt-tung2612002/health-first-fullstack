package com.springboot.userservice.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "uni_username", columnNames = "username")
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String username;

    @NonNull
    private Date createdDate;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String displayName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<com.springboot.userservice.entity.AppRole> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_region_management", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ward_id"))
    private Set<com.springboot.userservice.entity.Ward> wards = new HashSet<>();

    @OneToMany(mappedBy = "createdUser", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<com.springboot.userservice.entity.Activity> activities = new HashSet<>();

    @OneToMany(mappedBy = "createdUser", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Plan> plans = new HashSet<>();

}
