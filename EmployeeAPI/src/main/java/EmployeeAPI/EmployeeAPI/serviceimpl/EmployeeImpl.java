package EmployeeAPI.EmployeeAPI.serviceimpl;


import EmployeeAPI.EmployeeAPI.Entities.EmployeeEntities;
import EmployeeAPI.EmployeeAPI.Repository.EmployeeRepository;
import EmployeeAPI.EmployeeAPI.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
     private BCryptPasswordEncoder passwordEncoder;

    @Override
    public EmployeeEntities CreateUser(EmployeeEntities employeeEntities) {
      return employeeRepository.saveAndFlush(employeeEntities);
    }

    @Override
    public EmployeeEntities getUser(EmployeeEntities employeeEntities) {
        return employeeRepository.findById(employeeEntities.getEmp_id()).get() ;
    }

    @Override
    public EmployeeEntities getEmployeeById(long id) {
       return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntities updateUser(EmployeeEntities employeeEntities) {
        return employeeRepository.saveAndFlush(employeeEntities);
    }

    @Override
    public void deleteUser(Long emp_id) {
        employeeRepository.deleteById(emp_id);
    }

    @Override
    public List<EmployeeEntities> fetchEntitiesList() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntities registerUser(EmployeeEntities employeeEntities) {
        employeeEntities.setEmp_password(passwordEncoder.encode(employeeEntities.getEmp_password()));
        return employeeRepository.save(employeeEntities);
    }

    @Override
    public EmployeeEntities loginUser(String username, String emp_password) {
        EmployeeEntities employeeEntities = employeeRepository.findByUsername(username).orElse(null);
        if (employeeEntities != null && passwordEncoder.matches(emp_password, employeeEntities.getEmp_password())) {
            return employeeEntities;
        } else {
            return null;
        }
    }}



