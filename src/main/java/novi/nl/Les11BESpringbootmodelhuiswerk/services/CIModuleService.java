package novi.nl.Les11BESpringbootmodelhuiswerk.services;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.CIModuleDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.CIModuleInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.CIModule;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.CIModuleRepository;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {
    private static CIModuleRepository ciModuleRepository;
    private static TelevisionRepository televisionRepository;

    public CIModuleService(CIModuleRepository cimoduleRepository, TelevisionRepository televisionRepository) {
        this.ciModuleRepository = cimoduleRepository;
        this.televisionRepository = televisionRepository;
    }

    // GetMapping, functie voor het ophalen van alle CIModules
    public List<CIModuleDto> getAllCIModules() {
        List<CIModule> cimodules = ciModuleRepository.findAll();
        ArrayList<CIModuleDto> cimoduleDtos = new ArrayList<>();
        for (CIModule cimodule : cimodules) {
            CIModuleDto cimoduleDto = transfertoDto(cimodule);
            cimoduleDtos.add(cimoduleDto);
        }
        return cimoduleDtos;
    }

    // GetMapping by id, functie voor het ophalen van 1 CIModule, cf hw klas
    public CIModuleDto getCIModule(Long id) {
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);
        if (!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("No cimodule found with id: " + id + ".");
        } else {
            CIModule cimodule1 = optionalCIModule.get();
            return transfertoDto(cimodule1);
        }
    }

    //     PostMapping, functie voor het opslaan van 1 CIModule, in de les gemaakt
    public Long createCIModule(CIModuleInputDto cimoduleInputDto) {
        CIModule newCIModule = new CIModule();
        newCIModule = transfertoCIModule(cimoduleInputDto);
        CIModule savedCIModule = ciModuleRepository.save(newCIModule);
        return savedCIModule.getId();
    }


    // functie voor het updaten van een televisie waarbij een dto wordt teruggegeven
    public CIModuleDto updatedCIModule(Long id, CIModuleInputDto cimoduleInputDto) {
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);
        if (ciModuleRepository.existsById(id)) {
            CIModule cimoduleToUpdate = optionalCIModule.get();

            if (cimoduleInputDto.getName() != null) {
                cimoduleToUpdate.setName(cimoduleInputDto.getName());
            }
            if (cimoduleInputDto.getType() != null) {
                cimoduleToUpdate.setType(cimoduleInputDto.getType());
            }
            if (cimoduleInputDto.getPrice() != null) {
                cimoduleToUpdate.setPrice(cimoduleInputDto.getPrice());
            }

            CIModule savedCIModule = ciModuleRepository.save(cimoduleToUpdate);
            return transfertoDto(savedCIModule);
        } else {
            throw new RecordNotFoundException("No cimodule with id " + id);
        }
    }

    // bij DeleteMapping, functie voor het verwijderen van 1 CIModule, gemaakt in de les
    public String deleteById(Long id) {
        if (ciModuleRepository.existsById(id)) {
            Optional<CIModule> deletedCIModule = ciModuleRepository.findById(id);
            CIModule cimodule1 = deletedCIModule.get();
            ciModuleRepository.delete(cimodule1);
            return "CIModule with id: " + id + " deleted.";
        } else {
            throw new RecordNotFoundException("No cimodule found with id: " + id + ".");
        }
    }

        public static void assignTelevisionToCIModule(Long id, Long televisionId) {
        Optional<Television> optionalTelevision = televisionRepository.findById(televisionId);
        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(id);
        if (optionalTelevision.isPresent() && optionalCIModule.isPresent()) {
            Television television = optionalTelevision.get();
            CIModule ciModule = optionalCIModule.get();
            ciModule.setTelevision(television);
            ciModuleRepository.save(ciModule);
        } else {
            throw new RecordNotFoundException();
        }
    }


    // helper method from CIModule to Dto
    private CIModuleDto transfertoDto(CIModule cimodule) {
        CIModuleDto cimoduleDto = new CIModuleDto();
        cimoduleDto.setType(cimodule.getType());
        cimoduleDto.setName(cimodule.getName());
        cimoduleDto.setPrice(cimodule.getPrice());
        if(cimodule.getTelevision() != null) {
            cimoduleDto.setTelevision(cimodule.getTelevision());
        }
        return cimoduleDto;
    }

    //helper method from Dto to CIModule
    public CIModule transfertoCIModule(CIModuleInputDto cimoduleInputDto) {
        CIModule cimodule = new CIModule();
        cimodule.setType(cimoduleInputDto.getType());
        cimodule.setName(cimoduleInputDto.getName());
        cimodule.setPrice(cimoduleInputDto.getPrice());
        return cimodule;
    }
}




