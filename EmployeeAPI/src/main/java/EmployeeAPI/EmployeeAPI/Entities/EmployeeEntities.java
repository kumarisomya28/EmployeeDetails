package EmployeeAPI.EmployeeAPI.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emp_id;


//    @NotEmpty
//    @Size(min = 5,max=10,message = "not valid")
//    @Column(name ="emp_name")
//    private String emp_name;
    @Column(name ="emp_salary")
    private float emp_salary;
    @Column(name ="emp_city")
    private String emp_city;
    @Column(name ="emp_designation")
    private String emp_designation;
    @Column(name ="emp_age")
    private int emp_age;
    @Column(name ="emp_contactNo")
    private long emp_contactNo;
    @Column(name ="emp_DateOfJoining")
    private LocalDate emp_DateOfJoining;
    @Column(name ="emp_DateOfBirth")
    private Date emp_DateOfBirth;
    @Column(name ="emp_isActive")
    private Boolean emp_isActive;
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String emp_email;

    @NotBlank(message = "use strong password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,}$",message = "must be one capital letter,must be one special character,must be one number")
    @Column(name ="emp_password")
    private String emp_password;

}
