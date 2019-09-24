package dk.trifork.vocation.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USER_ROLE")
@Data
public class UserRole {
    @Id
    @Column(name = "USER_ROLE_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(name = "ROLE", nullable = false)
    @NotNull
    protected String role;

    @ManyToMany
    @JoinColumn(name = "FK_TO_EMPLOYEE")
    protected Set<Employee> employees = new HashSet<>();

}
