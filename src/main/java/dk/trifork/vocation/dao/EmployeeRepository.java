package dk.trifork.vocation.dao;

import dk.trifork.vocation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    //JPQL
    @Query("select e from Employee e where e.employeeId = :id")
    Optional<Employee> findEmployeeByEmployeeId(@Param("id") String id);

}
