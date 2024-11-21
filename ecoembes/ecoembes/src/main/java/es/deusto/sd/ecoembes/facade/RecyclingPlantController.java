package es.deusto.sd.ecoembes.facade;

import es.deusto.sd.ecoembes.service.RecyclingPlantService;
import es.deusto.sd.ecoembes.dto.RecyclingPlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plants")
public class RecyclingPlantController {
    @Autowired
    private RecyclingPlantService plantService;

    @GetMapping("/{id}")
    public RecyclingPlantDTO getPlant(@PathVariable String id) {
        return plantService.getPlantById(id);
    }

    @PostMapping
    public RecyclingPlantDTO registerPlant(@RequestBody RecyclingPlantDTO dto) {
        return plantService.registerPlant(dto);
    }

    @PutMapping("/{id}/capacity")
    public void updateCapacity(@PathVariable String id, @RequestBody double newCapacity) {
        plantService.updateCapacity(id, newCapacity);
    }
}

