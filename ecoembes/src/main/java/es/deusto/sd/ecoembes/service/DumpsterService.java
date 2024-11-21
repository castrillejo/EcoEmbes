package es.deusto.sd.ecoembes.service;

import org.springframework.stereotype.Service;
import es.deusto.sd.ecoembes.assembler.DumpsterAssembler;
import es.deusto.sd.ecoembes.entity.Dumpster;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import es.deusto.sd.ecoembes.entity.FillLevelStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DumpsterService {

    private final Map<String, Dumpster> dumpsters = new HashMap<>();

    public DumpsterService() {
        // Agregando un dumpster de ejemplo para pruebas
        Dumpster sampleDumpster = new Dumpster("1", "Calle Principal 123", 3, FillLevelStatus.GREEN);
        dumpsters.put(sampleDumpster.getId(), sampleDumpster);
    }

    public List<DumpsterDTO> getAllDumpsters() {
        List<DumpsterDTO> dumpsterDTOs = new ArrayList<>();
        for (Dumpster dumpster : dumpsters.values()) {
            dumpsterDTOs.add(DumpsterAssembler.getInstance().toDTO(dumpster));
        }
        return dumpsterDTOs;
    }

    public DumpsterDTO getDumpsterById(String id) {
        Dumpster dumpster = dumpsters.get(id);
        return dumpster != null ? DumpsterAssembler.getInstance().toDTO(dumpster) : null;
    }

    public DumpsterDTO createDumpster(DumpsterDTO dumpsterDTO) {
        Dumpster dumpster = DumpsterAssembler.getInstance().toDomain(dumpsterDTO);
        dumpsters.put(dumpster.getId(), dumpster);
        return DumpsterAssembler.getInstance().toDTO(dumpster);
    }

    public boolean deleteDumpster(String id) {
        return dumpsters.remove(id) != null;
    }
}
