package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.RemoteControllerDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.RemoteControllerInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.services.RemoteControllerService;
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
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {
    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService remotecontrollerService) {
        this.service = remotecontrollerService;
    }


    @GetMapping("")
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {
        return ResponseEntity.ok(service.getAllRemoteControllers());
    }

    // in de hw klas gemaakt
    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteController(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRemoteController(id));
    }

    // in de les gemaakt
    @PostMapping("")
    public ResponseEntity<String> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remotecontrollerInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String errorString = getErrorString(br);
            return new ResponseEntity<>(errorString, HttpStatus.BAD_REQUEST);
        } else {
            Long createdId = service.createRemoteController(remotecontrollerInputDto);
            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/remotecontrollers/" + createdId)
                    .toUriString());
            return ResponseEntity.created(uri).body("RemoteController created.");
        }
    }


    // onderstaande geeft een RemoteControllerDto terug ipv String
    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @Valid @RequestBody RemoteControllerInputDto remotecontrollerInputDto) {
        RemoteControllerDto remotecontrollerDto = service.updatedRemoteController(id, remotecontrollerInputDto);
        return ResponseEntity.ok().body(remotecontrollerDto);
    }

    // in hw klas gemaakt
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


