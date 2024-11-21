package es.deusto.sd.ecoembes.service;
import org.springframework.stereotype.Service;
import es.deusto.sd.ecoembes.assembler.DumpsterAssembler;
import es.deusto.sd.ecoembes.entity.Dumpster;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import java.util.HashMap;
import java.util.Map;

@Service
public class DumpsterService {
    private Map<String, Dumpster> dumpsters = new HashMap<>();

    public DumpsterDTO getDumpsterById(String id) {
        Dumpster dumpster = dumpsters.get(id);
        return dumpster != null ? DumpsterAssembler.getInstance().toDTO(dumpster) : null;
    }

    public DumpsterDTO registerDumpster(DumpsterDTO dto) {
        Dumpster dumpster = DumpsterAssembler.getInstance().toDomain(dto);
        dumpsters.put(dumpster.getId(), dumpster);
        return DumpsterAssembler.getInstance().toDTO(dumpster);
    }
}

