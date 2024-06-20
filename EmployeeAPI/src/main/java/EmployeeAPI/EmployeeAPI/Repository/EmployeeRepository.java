package EmployeeAPI.EmployeeAPI.Repository;


import EmployeeAPI.EmployeeAPI.Entities.EmployeeEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntities,Long> {
    Optional<EmployeeEntities> findByUsername(String username);

}
