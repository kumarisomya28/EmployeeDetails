package EmployeeAPI.EmployeeAPI.Controller;

import EmployeeAPI.EmployeeAPI.Entities.EmployeeEntities;
import EmployeeAPI.EmployeeAPI.Services.EmployeeServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name="Employee API",description = "To perform operations on Employee details")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/save")
    @Operation(
            summary = "POST operations on Employee details",
            description = "It is used to save employee object in database "
    )

    public ResponseEntity<EmployeeEntities> saveUser(@Valid @RequestBody EmployeeEntities employeeEntities){
        EmployeeEntities savedUser = employeeServices.CreateUser(employeeEntities);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "GET operations on Employee by using employee id",
            description = "It is used to retrive employee object from database using employee id "
    )
    public ResponseEntity<EmployeeEntities> getEmployeeId(@PathVariable("id") int id) {
        EmployeeEntities employee = employeeServices.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "PUT operations on Employee details",
            description = "It is used to retrive employee object from database "
    )
    public ResponseEntity<EmployeeEntities> updateEmployee(@RequestBody EmployeeEntities employeeEntities) {
        EmployeeEntities updateEmployee = employeeServices.updateUser(employeeEntities);
        return ResponseEntity.status(HttpStatus.OK).body(updateEmployee);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "DELETE operations on Employee details by id",
            description = "It is used to delete employee object by id from database "
    )
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
        employeeServices.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/list")
    @Operation(
            summary = "GET operations on Employee details",
            description = "It is used to retrive employee object from database "
    )
    public ResponseEntity<List<EmployeeEntities>> getAllEmployee() {
        List<EmployeeEntities> employees = employeeServices.fetchEntitiesList();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PatchMapping("{id}")
    @Operation(
            summary = "PATCH operations on Employee details",
            description = "It is used to patch employee object from database "
    )
    public ResponseEntity<EmployeeEntities> patchEmployee(@PathVariable("id") long id, @RequestBody EmployeeEntities employeeEntities){
        EmployeeEntities patchEmployee = employeeServices.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<EmployeeEntities> signup(@RequestParam String username,@RequestParam String emp_password){
        EmployeeEntities employeeEntities =employeeServices.loginUser(username, emp_password);
        if (employeeEntities != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}




