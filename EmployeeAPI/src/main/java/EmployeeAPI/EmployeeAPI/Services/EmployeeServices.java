package EmployeeAPI.EmployeeAPI.Services;



import EmployeeAPI.EmployeeAPI.Entities.EmployeeEntities;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServices {
    EmployeeEntities CreateUser(EmployeeEntities employeeEntities);
    EmployeeEntities getUser(EmployeeEntities employeeEntities);
    EmployeeEntities getEmployeeById(long id);
    EmployeeEntities updateUser(EmployeeEntities employeeEntities);
    void deleteUser(Long emp_id);
    List<EmployeeEntities> fetchEntitiesList();
    EmployeeEntities registerUser(EmployeeEntities employeeEntities);
    EmployeeEntities loginUser(String username,String emp_password);

}
