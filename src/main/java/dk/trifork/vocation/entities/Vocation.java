package dk.trifork.vocation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dk.trifork.vocation.domainmodel.VocationStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "VOCATION")
@Data
public class Vocation {

    @Id
    @Column(name = "VOCATION_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(name = "Start_Time", nullable = false)
    @NotNull
    protected LocalDateTime startingDateTime;

    @Column(name = "End_Time", nullable = false)
    @NotNull
    protected LocalDateTime endingDateTime;

    @Column(name = "VOCATION_STATUS")
    @Enumerated(EnumType.STRING)
    protected VocationStatus status;

    @ManyToOne
    @JoinColumn(name = "FK_TO_EMPLOYEE")
    protected Employee employee;

    public Vocation() {
        this.status = VocationStatus.PENDING;  //any vocation initially is in a pending status.
    }
}
