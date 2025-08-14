package MsSqlProject.myls.Service;


import MsSqlProject.myls.Dto.employeeDto;
import MsSqlProject.myls.Entity.Employee;

public interface employeeService {
     employeeDto createEmployee(Employee employee);

     employeeDto getEmployeeById(String id);

    void deleteEmployee(String id);

    employeeDto updateEmployee(String id, employeeDto employeeDto );
}
