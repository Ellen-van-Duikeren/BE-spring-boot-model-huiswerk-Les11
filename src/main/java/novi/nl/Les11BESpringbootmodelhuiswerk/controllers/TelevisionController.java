package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.ResourceNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")

public class TelevisionController {
    @Autowired
    private TelevisionRepository repos;

    @GetMapping("")
    public ResponseEntity<Iterable<Television>> getTelevisions() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createTelevision(@RequestBody Television television) {
        Television savedTelevision = repos.save(television);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/televisions/" + savedTelevision.getId()).toUriString());
        return ResponseEntity.created(uri).body("Television saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable long id, @RequestBody Television television) {
        // eerst een optional aanmaken want je weet nog niet of dit id bestaat
        Optional<Television> updateTelevision = repos.findById(id);
        if (updateTelevision.isPresent()) {
            //als de id bestaat ga je de optional bewaren in een echte variabele
            Television television1 = updateTelevision.get();
            television1.setName(television.getName());
            repos.save(television1);
            return ResponseEntity.ok(television1);
        } else {
            throw new ResourceNotFoundException("Television not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable long id) {
        Optional<Television> television = repos.findById(id);
        if (television.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Television television1 = television.get();
            repos.delete(television1);
            return ResponseEntity.ok("Television deleted");
        }
    }

    @GetMapping("/pricesUnder")
    public ResponseEntity<Iterable<Television>> getTelevisionsUnderPrice(@RequestParam double price) {
        return ResponseEntity.ok(repos.findByPriceLessThan(price));
    }

    @GetMapping("/byBrand")
    public ResponseEntity<Iterable<Television>> getTelevisionsByBrand(@RequestParam String brand) {
        return ResponseEntity.ok(repos.findByBrand(brand));
    }
}


