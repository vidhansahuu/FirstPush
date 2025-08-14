package MsSqlProject.myls.Service.impl;

import MsSqlProject.myls.Dto.employeeDto;
import MsSqlProject.myls.Entity.Employee;
import MsSqlProject.myls.Repository.employeeRepository;
import MsSqlProject.myls.Service.employeeService;
import MsSqlProject.myls.exception.EmployeeNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class employeeServiceImpl implements employeeService {
    @Autowired
    private employeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public employeeDto createEmployee(Employee employee) {
        Employee savedData = employeeRepository.save(employee);
          employeeDto employeeDto = convertToDTO(savedData);
           return employeeDto;
    }

    @Override
    public employeeDto getEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeDto employeeDto = convertToDTO(employee);
        return employeeDto;
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
                 employeeRepository.deleteById(id);
    }


    public employeeDto updateEmployee(String id, employeeDto employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {

            Employee updatedEmployee = existingEmployee.get();

            updatedEmployee.setName(employee.getName());
            updatedEmployee.setCity(employee.getCity());
            updatedEmployee.setDepartment(employee.getDepartment());

            Employee updatedEmployeee = employeeRepository.save(updatedEmployee);

            employeeDto employeeDto = convertToDTO(updatedEmployeee);

            return employeeDto;
        } else {
            return null;
        }
    }


    public employeeDto convertToDTO(Employee employee) {
        return modelMapper.map(employee, employeeDto.class);
    }


}
