package MsSqlProject.myls.Controller;

import MsSqlProject.myls.Dto.employeeDto;
import MsSqlProject.myls.Entity.Employee;
import MsSqlProject.myls.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class employeeController {
    @Autowired
    private employeeService employeeService;

    @PostMapping("/createUser")
      public ResponseEntity<employeeDto> createEmployee(@RequestBody   Employee employee){
        employeeDto employeedata = employeeService.createEmployee(employee);
         return new ResponseEntity<>(employeedata, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<employeeDto> getEmployeeById(@PathVariable String id) {
        employeeDto employeedata = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeedata, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteEmployee(@PathVariable String id){
               employeeService.deleteEmployee(id);
        return new ResponseEntity<>("EMPLOYEE WITH ID--" +id+ "--IS DELETED",HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody employeeDto  employeeDto) {
        employeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("EMPLOYEE NOT FOUND WITH ID" +id,HttpStatus.NOT_FOUND);
        }
    }


    }




