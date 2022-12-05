package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.CIModuleDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.CIModuleInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.services.CIModuleService;
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
@RequestMapping("/cimodules")
public class CIModuleController {
    private final CIModuleService service;

    public CIModuleController(CIModuleService cimoduleService) {
        this.service = cimoduleService;
    }


    @GetMapping("")
    public ResponseEntity<List<CIModuleDto>> getAllCIModules() {
        return ResponseEntity.ok(service.getAllCIModules());
    }

    // in de hw klas gemaakt
    @GetMapping("/{id}")
    public ResponseEntity<CIModuleDto> getCIModule(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCIModule(id));
    }

    // in de les gemaakt
    @PostMapping("")
    public ResponseEntity<String> createCIModule(@Valid @RequestBody CIModuleInputDto cimoduleInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = service.createCIModule(cimoduleInputDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/cimodules/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("CIModule created.");
        }
    }

    // onderstaande geeft een CIModuleDto terug ipv String
    @PutMapping("/{id}")
    public ResponseEntity<CIModuleDto> updateCIModule(@PathVariable Long id, @Valid @RequestBody CIModuleInputDto cimoduleInputDto) {
        CIModuleDto cimoduleDto = service.updatedCIModule(id, cimoduleInputDto);
        return ResponseEntity.ok().body(cimoduleDto);
    }

    // in hw klas gemaakt
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCIModule(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Assign Television to CIModule
        @PutMapping("/{id}/television/{televisionId}")
    public void assignTelevisionToCIModule(@PathVariable Long id, @PathVariable Long televisionId) {
        CIModuleService.assignTelevisionToCIModule(id, televisionId);
    }
}


