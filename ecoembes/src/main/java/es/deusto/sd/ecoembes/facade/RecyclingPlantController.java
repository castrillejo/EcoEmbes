package es.deusto.sd.ecoembes.facade;

import es.deusto.sd.ecoembes.service.RecyclingPlantService;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import es.deusto.sd.ecoembes.dto.RecyclingPlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recycling-plant")
public class RecyclingPlantController {
    @Autowired
    private RecyclingPlantService plantService;

    @GetMapping("/{id}")
    public RecyclingPlantDTO getPlant(@PathVariable("id") String id) {
        return plantService.getPlantById(id);
    }

    @PostMapping
    public ResponseEntity<RecyclingPlantDTO> registerPlant(@RequestBody RecyclingPlantDTO dto) {
        System.out.println("Recibiendo solicitud para registrar planta: " + dto);  // Imprime la solicitud recibida
        RecyclingPlantDTO newPlant = plantService.registerPlant(dto);
        System.out.println("Planta registrada: " + newPlant); // Imprime el resultado de la creación

        if (newPlant != null) {
            return new ResponseEntity<>(newPlant, HttpStatus.CREATED); // Si la planta fue creada correctamente
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Si hubo un error en la creación
        }
    }

    // Nuevo endpoint para obtener la capacidad de una planta
    @GetMapping("/{id}/capacity")
    public ResponseEntity<Double> getPlantCapacity(@PathVariable("id") String id) {
        try {
            double capacity = plantService.getPlantCapacityById(id);
            return new ResponseEntity<>(capacity, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();  // Log the error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
