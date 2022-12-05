package novi.nl.Les11BESpringbootmodelhuiswerk.services;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.RemoteControllerDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.RemoteControllerInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.RemoteController;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    // intransferToDto
//    dto.setRemoteController(remoteController.getTelevision());

    private final RemoteControllerRepository repository;

    public RemoteControllerService(RemoteControllerRepository remotecontrollerRepository) {
        this.repository = remotecontrollerRepository;
    }

    // GetMapping, functie voor het ophalen van alle RemoteControllers
    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteController> remotecontrollers = repository.findAll();
        ArrayList<RemoteControllerDto> remotecontrollerDtos = new ArrayList<>();
        for (RemoteController remotecontroller : remotecontrollers) {
            RemoteControllerDto remotecontrollerDto = transfertoDto(remotecontroller);
            remotecontrollerDtos.add(remotecontrollerDto);
        }
        return remotecontrollerDtos;
    }

    // GetMapping by id, functie voor het ophalen van 1 RemoteController, cf hw klas
    public RemoteControllerDto getRemoteController(Long id) {
        Optional<RemoteController> optionalRemoteController = repository.findById(id);
        if (!repository.existsById(id)) {
            throw new RecordNotFoundException("No remotecontroller found with id: " + id + ".");
        } else {
            RemoteController remotecontroller1 = optionalRemoteController.get();
            return transfertoDto(remotecontroller1);
        }
    }

    //     PostMapping, functie voor het opslaan van 1 RemoteController, in de les gemaakt
    public Long createRemoteController(RemoteControllerInputDto remotecontrollerInputDto) {
        RemoteController newRemoteController = new RemoteController();
        newRemoteController = transfertoRemoteController(remotecontrollerInputDto);
        RemoteController savedRemoteController = repository.save(newRemoteController);
        return savedRemoteController.getId();
    }


    // functie voor het updaten van een televisie waarbij een dto wordt teruggegeven
    public RemoteControllerDto updatedRemoteController(Long id, RemoteControllerInputDto remotecontrollerInputDto) {
        Optional<RemoteController> optionalRemoteController = repository.findById(id);
        if (repository.existsById(id)) {
            RemoteController remotecontrollerToUpdate = optionalRemoteController.get();

            if (remotecontrollerInputDto.getBrand() != null) {
                remotecontrollerToUpdate.setBrand(remotecontrollerInputDto.getBrand());
            }
            if (remotecontrollerInputDto.getName() != null) {
                remotecontrollerToUpdate.setName(remotecontrollerInputDto.getName());
            }
            if (remotecontrollerInputDto.getOriginalStock() != null) {
                remotecontrollerToUpdate.setOriginalStock(remotecontrollerInputDto.getOriginalStock());
            }
            if (remotecontrollerInputDto.getPrice() != null) {
                remotecontrollerToUpdate.setPrice(remotecontrollerInputDto.getPrice());
            }
            if (remotecontrollerInputDto.getCompatibleWith() != null) {
                remotecontrollerToUpdate.setCompatibleWith(remotecontrollerInputDto.getCompatibleWith());
            }
            if (remotecontrollerInputDto.getOriginalStock() != null) {
                remotecontrollerToUpdate.setOriginalStock(remotecontrollerInputDto.getOriginalStock());
            }
            RemoteController savedRemoteController = repository.save(remotecontrollerToUpdate);
            return transfertoDto(savedRemoteController);
        } else {
            throw new RecordNotFoundException("No remotecontroller with id " + id);
        }
    }

    // bij DeleteMapping, functie voor het verwijderen van 1 RemoteController, gemaakt in de les
    public String deleteById(Long id) {
        if (repository.existsById(id)) {
            Optional<RemoteController> deletedRemoteController = repository.findById(id);
            RemoteController remotecontroller1 = deletedRemoteController.get();
            repository.delete(remotecontroller1);
            return "RemoteController with id: " + id + " deleted.";
        } else {
            throw new RecordNotFoundException("No remotecontroller found with id: " + id + ".");
        }
    }

    // helper method from RemoteController to Dto
    private RemoteControllerDto transfertoDto(RemoteController remotecontroller) {
        RemoteControllerDto remotecontrollerDto = new RemoteControllerDto();
        remotecontrollerDto.setBatteryType(remotecontroller.getBatteryType());
        remotecontrollerDto.setBrand(remotecontroller.getBrand());
        remotecontrollerDto.setName(remotecontroller.getName());
        remotecontrollerDto.setPrice(remotecontroller.getPrice());
        remotecontrollerDto.setCompatibleWith(remotecontroller.getCompatibleWith());
        remotecontrollerDto.setOriginalStock(remotecontroller.getOriginalStock());
        remotecontrollerDto.setOriginalStock(remotecontroller.getOriginalStock());


        return remotecontrollerDto;
    }

    //helper method from Dto to RemoteController
    public RemoteController transfertoRemoteController(RemoteControllerInputDto remotecontrollerInputDto) {
        RemoteController remotecontroller = new RemoteController();
        remotecontroller.setBatteryType(remotecontrollerInputDto.getBatteryType());
        remotecontroller.setName(remotecontrollerInputDto.getName());
        remotecontroller.setCompatibleWith(remotecontrollerInputDto.getCompatibleWith());
        remotecontroller.setOriginalStock(remotecontrollerInputDto.getOriginalStock());
        remotecontroller.setBrand(remotecontrollerInputDto.getBrand());
        remotecontroller.setPrice(remotecontrollerInputDto.getPrice());
        remotecontroller.setOriginalStock(remotecontrollerInputDto.getOriginalStock());
        return remotecontroller;
    }
}


