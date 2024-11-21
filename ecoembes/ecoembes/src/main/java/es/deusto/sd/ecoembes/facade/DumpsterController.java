package es.deusto.sd.ecoembes.facade;

import es.deusto.sd.ecoembes.service.DumpsterService;
import es.deusto.sd.ecoembes.dto.DumpsterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dumpsters")
public class DumpsterController {
    @Autowired
    private DumpsterService dumpsterService;

    @GetMapping("/{id}")
    public DumpsterDTO getDumpster(@PathVariable String id) {
        return dumpsterService.getDumpsterById(id);
    }

    @PostMapping
    public DumpsterDTO registerDumpster(@RequestBody DumpsterDTO dto) {
        return dumpsterService.registerDumpster(dto);
    }
}


