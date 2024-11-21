package es.deusto.sd.ecoembes.service;

import org.springframework.stereotype.Service;
import es.deusto.sd.ecoembes.assembler.RecyclingPlantAssembler;
import es.deusto.sd.ecoembes.entity.RecyclingPlant;
import es.deusto.sd.ecoembes.dto.RecyclingPlantDTO;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecyclingPlantService {
    private Map<String, RecyclingPlant> plants = new HashMap<>();

    public RecyclingPlantDTO getPlantById(String id) {
        RecyclingPlant plant = plants.get(id);
        return plant != null ? RecyclingPlantAssembler.getInstance().toDTO(plant) : null;
    }

    public RecyclingPlantDTO registerPlant(RecyclingPlantDTO dto) {
        RecyclingPlant plant = RecyclingPlantAssembler.getInstance().toDomain(dto);
        plants.put(plant.getId(), plant);
        return RecyclingPlantAssembler.getInstance().toDTO(plant);
    }

    public void updateCapacity(String id, double newCapacity) {
        RecyclingPlant plant = plants.get(id);
        if (plant != null) {
            plant.setCapacity(newCapacity);
        }
    }
}

