package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.TelevisionDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.dto.TelevisionInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static novi.nl.Les11BESpringbootmodelhuiswerk.util.Utilities.getErrorString;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    private final TelevisionService service;
    public TelevisionController(TelevisionService televisionService) {
        this.service = televisionService;
    }


    @GetMapping("")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        return ResponseEntity.ok(service.getAllTelevisions());
    }

    // in de hw klas gemaakt
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTelevision(id));
    }

    // in de les gemaakt
    @PostMapping("")
    public ResponseEntity<String> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = service.createTelevision(televisionInputDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/televisions/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("Television created.");
        }
    }

//    cf in de les
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
//        if (br.hasErrors()) {
//            String errorString = getErrorString(br);
//            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
//        } else {
//            Long updatedId = service.updateTelevision(id, televisionInputDto);
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(updatedId)
//                    .toUri();
//            return ResponseEntity.created(location).body("Television updated.");
//        }
//    }

    // onderstaande geeft een TelevisionDto terug ipv String
    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto televisionDto = service.updatedTelevision(id, televisionInputDto);
        return ResponseEntity.ok().body(televisionDto);
    }

    // in hw klas gemaakt
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


