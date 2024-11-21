package es.deusto.sd.ecoembes.assembler;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import es.deusto.sd.ecoembes.entity.Dumpster;

public class DumpsterAssembler {
    private static final DumpsterAssembler instance = new DumpsterAssembler();

    private DumpsterAssembler() {}

    public static DumpsterAssembler getInstance() {
        return instance;
    }

    public DumpsterDTO toDTO(Dumpster dumpster) {
        return new DumpsterDTO(dumpster.getId(), dumpster.getLocation(), dumpster.getContainerCount(), dumpster.getFillLevel());
    }

    public Dumpster toDomain(DumpsterDTO dto) {
        return new Dumpster(dto.getId(), dto.getLocation(), dto.getContainerCount(), dto.getFillLevel());
    }
}

