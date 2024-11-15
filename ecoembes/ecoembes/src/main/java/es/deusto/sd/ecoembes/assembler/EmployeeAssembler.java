package es.deusto.sd.ecoembes.assembler;
import es.deusto.sd.ecoembes.dto.EmployeeDTO;
import es.deusto.sd.ecoembes.entity.Employee;


public class EmployeeAssembler {
    private static final EmployeeAssembler instance = new EmployeeAssembler();

    private EmployeeAssembler() {}

    public static EmployeeAssembler getInstance() {
        return instance;
    }

    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getRole());
    }

    public Employee toDomain(EmployeeDTO dto) {
        return new Employee(dto.getId(), dto.getName(), dto.getRole());
    }
}

