package EmployeeAPI.EmployeeAPI.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

    private Long emp_id;

//    private String emp_name;

    private float emp_salary;

    private String emp_city;

    private String emp_designation;

    private int emp_age;

    private int emp_contactNo;

    private LocalDate emp_DateOfJoining;

    private Date emp_DateOfBirth;

    private Boolean emp_isActive;

    private String emp_password;
    private String emp_email;
    private String username;
}
