package es.deusto.sd.ecoembes.assembler;
import es.deusto.sd.ecoembes.dto.RecyclingPlantDTO;
import es.deusto.sd.ecoembes.entity.RecyclingPlant;

public class RecyclingPlantAssembler {
    private static final RecyclingPlantAssembler instance = new RecyclingPlantAssembler();

    private RecyclingPlantAssembler() {}

    public static RecyclingPlantAssembler getInstance() {
        return instance;
    }

    public RecyclingPlantDTO toDTO(RecyclingPlant plant) {
        return new RecyclingPlantDTO(plant.getId(), plant.getName(), plant.getCapacity(), plant.getAvailableDate());
    }

    public RecyclingPlant toDomain(RecyclingPlantDTO dto) {
        return new RecyclingPlant(dto.getId(), dto.getName(), dto.getCapacity(), dto.getAvailableDate());
    }
}

