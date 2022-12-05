package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.WallBracketDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.WallBracketInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.services.WallBracketService;
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
@RequestMapping("/wallbrackets")
public class WallBracketController {
    private final WallBracketService service;

    public WallBracketController(WallBracketService wallBracketService) {
        this.service = wallBracketService;
    }


    @GetMapping("")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        return ResponseEntity.ok(service.getAllWallBrackets());
    }

    // in de hw klas gemaakt
    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(service.getWallBracket(id));
    }

    // in de les gemaakt
    @PostMapping("")
    public ResponseEntity<String> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = service.createWallBracket(wallBracketInputDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/wallBrackets/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("WallBracket created.");
        }
    }


    // onderstaande geeft een WallBracketDto terug ipv String
    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto wallBracketDto = service.updatedWallBracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(wallBracketDto);
    }

    // in hw klas gemaakt
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

