package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.outputDto.WallBracketOutputDto;
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
    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


    @GetMapping("")
    public ResponseEntity<List<WallBracketOutputDto>> getAllWallBrackets() {
        return ResponseEntity.ok(wallBracketService.getAllWallBrackets());
    }


    @GetMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }


    @PostMapping("")
    public ResponseEntity<String> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = wallBracketService.createWallBracket(wallBracketInputDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/wallBrackets/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("WallBracket created.");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketOutputDto wallBracketOutputDto = wallBracketService.updatedWallBracket(id, wallBracketInputDto);
        return ResponseEntity.ok().body(wallBracketOutputDto);
    }

//    @PutMapping("/{id}/television/{televisionId}")
//    public ResponseEntity<String> assignTelevisionToWallbracket(@PathVariable Long id, @PathVariable Long televisionId) {
//        wallBracketService.assignTelevisionToWallbracket(id, televisionId);
//        return ResponseEntity.ok("succeeded");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

