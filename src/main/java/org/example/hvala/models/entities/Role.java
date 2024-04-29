package org.example.hvala.models.entities;

import jakarta.persistence.*;
import org.example.hvala.models.enums.RoleEnum;

import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    List<User> user;
    private RoleEnum name;

    protected Role() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
