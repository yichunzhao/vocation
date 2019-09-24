package dk.trifork.vocation.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
    @NotEmpty
    protected String employeeId;

    //one employee may have more than one role. one role many be applicable for many employee
    @Column(name = "ROLE")
    @ManyToMany(mappedBy = "employees")
    @NotEmpty
    protected Set<UserRole> roles = new HashSet<>();

    @Column(name = "VOCATION")
    @OneToMany(mappedBy = "employee")
    protected Set<Vocation> vocations = new HashSet<>();

    public void addVocation(Vocation vocation) {
        vocations.add(vocation);
    }

}
