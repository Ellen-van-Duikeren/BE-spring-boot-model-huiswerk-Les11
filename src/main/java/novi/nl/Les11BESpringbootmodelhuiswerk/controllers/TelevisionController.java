package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.outputDto.TelevisionOutputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.TelevisionInputDto;
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
    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("")
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    // in de hw klas gemaakt
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    // in de les gemaakt
    @PostMapping("")
    public ResponseEntity<String> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = televisionService.createTelevision(televisionInputDto);
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
    public ResponseEntity<TelevisionOutputDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto televisionOutputDto = televisionService.updatedTelevision(id, televisionInputDto);
        return ResponseEntity.ok().body(televisionOutputDto);
    }

    @PutMapping("/{id}/remotecontroller/{remoteControllerId}")
    public void assignRemoteControllerToTelevision(@PathVariable Long id, @PathVariable Long remoteControllerId) {
        televisionService.assignRemoteControllerToTelevision(id, remoteControllerId);
    }

//    @PutMapping("/{id}/cimodule/{ciModuleId}")
//    public void assignCIModuleToTelevision(@PathVariable Long id, @PathVariable Long ciModuleId) {
//        televisionService.assignCIModuleToTelevision(id, ciModuleId);
//    }

    @PutMapping("/{id}/wallbracket/{wallbracketId}")
    public ResponseEntity<String> assignWallBracketToTelevision(@PathVariable Long id, @PathVariable Long wallbracketId) {
        televisionService.assignWallBracketToTelevision(id, wallbracketId);
        return ResponseEntity.ok("succes");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


