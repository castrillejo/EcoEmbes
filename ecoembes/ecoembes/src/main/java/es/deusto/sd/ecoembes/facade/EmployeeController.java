package es.deusto.sd.ecoembes.facade;

import es.deusto.sd.ecoembes.service.EmployeeService;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import es.deusto.sd.ecoembes.dto.EmployeeDTO;
import es.deusto.sd.ecoembes.entity.Dumpster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // Get a specific employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO newEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return updatedEmployee != null ? new ResponseEntity<>(updatedEmployee, HttpStatus.OK)
                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //Add a list of dumpsters to a assigned plant
    @PutMapping("/{id}/assign-dumpsters")
    public List<DumpsterDTO> addDumpstersToPlant(String employeeId , String plantId, List<DumpsterDTO> list) {
		
    	
    	
    	
    	return list;
    }
    
    
    
    
    
    
}















