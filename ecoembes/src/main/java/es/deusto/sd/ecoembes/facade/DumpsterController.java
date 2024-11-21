package es.deusto.sd.ecoembes.facade;

import es.deusto.sd.ecoembes.service.DumpsterService;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dumpsters")
public class DumpsterController {

    private final DumpsterService dumpsterService;

    @Autowired
    public DumpsterController(DumpsterService dumpsterService) {
        this.dumpsterService = dumpsterService;
    }

    // Obtener todos los dumpsters
    @GetMapping
    public ResponseEntity<List<DumpsterDTO>> getAllDumpsters() {
        return new ResponseEntity<>(dumpsterService.getAllDumpsters(), HttpStatus.OK);
    }

    // Obtener un dumpster específico por ID
    @GetMapping("/{id}")
    public DumpsterDTO getDumpster(@PathVariable("id") String id) {
        return dumpsterService.getDumpsterById(id);
    }

    // Crear un nuevo dumpster
    @PostMapping
    public ResponseEntity<DumpsterDTO> createDumpster(@RequestBody DumpsterDTO dumpsterDTO) {
        DumpsterDTO newDumpster = dumpsterService.createDumpster(dumpsterDTO);
        return new ResponseEntity<>(newDumpster, HttpStatus.CREATED);
    }

    // Eliminar un dumpster
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDumpster(@PathVariable("id") String id) {
        boolean deleted = dumpsterService.deleteDumpster(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
