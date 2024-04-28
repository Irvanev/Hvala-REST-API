package org.example.hvala.models.entities;

import jakarta.persistence.*;
import org.example.hvala.models.enums.RoleEnum;

import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    private RoleEnum name;

    protected Role() {}

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
