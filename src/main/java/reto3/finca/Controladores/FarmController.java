package reto3.finca.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reto3.finca.entidades.Farms;
import reto3.finca.servicios.FarmService;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Farms> getFarms() {
        return farmService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farms> getFarm(@PathVariable("id") Long id) {
        return farmService.getFarm(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farms save(@RequestBody Farms f) {
        return farmService.save(f);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farms update(@RequestBody Farms f) {
        return farmService.update(f);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Long id) {
        return farmService.deleteFarm(id);
    }
}
