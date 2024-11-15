package es.deusto.sd.ecoembes.service;

import org.springframework.stereotype.Service;
import es.deusto.sd.ecoembes.assembler.EmployeeAssembler;
import es.deusto.sd.ecoembes.entity.Dumpster;
import es.deusto.sd.ecoembes.entity.Employee;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import es.deusto.sd.ecoembes.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();
    

    public EmployeeService() {
        // Adding a sample employee for testing
        Employee sampleEmployee = new Employee("1", "John Doe", "Manager");
        employees.put(sampleEmployee.getId(), sampleEmployee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees.values()) {
            employeeDTOs.add(EmployeeAssembler.getInstance().toDTO(employee));
        }
        return employeeDTOs;
    }

    public EmployeeDTO getEmployeeById(String id) {
        Employee employee = employees.get(id);
        return employee != null ? EmployeeAssembler.getInstance().toDTO(employee) : null;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeAssembler.getInstance().toDomain(employeeDTO);
        employees.put(employee.getId(), employee);
        return EmployeeAssembler.getInstance().toDTO(employee);
    }

    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setRole(employeeDTO.getRole());
            return EmployeeAssembler.getInstance().toDTO(existingEmployee);
        }
        return null;
    }

    public boolean deleteEmployee(String id) {
        return employees.remove(id) != null;
    }
    
    public boolean addDumpstersToPlant(String employeeId , String plantId, List<DumpsterDTO> list) {
    	
    }
}
