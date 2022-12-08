package novi.nl.Les11BESpringbootmodelhuiswerk.services;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.WallBracket;
import novi.nl.Les11BESpringbootmodelhuiswerk.outputDto.TelevisionOutputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.inputDto.TelevisionInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.RemoteController;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.CIModuleRepository;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.RemoteControllerRepository;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CIModuleRepository ciModuleRepository;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, CIModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }


    // GetMapping, functie voor het ophalen van alle Televisions
    public List<TelevisionOutputDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        ArrayList<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();
        for (Television television : televisions) {
            TelevisionOutputDto televisionOutputDto = transfertoDto(television);
            televisionOutputDtos.add(televisionOutputDto);
        }
        return televisionOutputDtos;
    }


    // GetMapping by id, functie voor het ophalen van 1 Television, cf hw klas
    public TelevisionOutputDto getTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found with id: " + id + ".");
        } else {
            Television television1 = optionalTelevision.get();
            return transfertoDto(television1);
        }
    }


    //     PostMapping, functie voor het opslaan van 1 Television, in de les gemaakt
    public Long createTelevision(TelevisionInputDto televisionInputDto) {
        Television newTelevision = new Television();
        newTelevision = transfertoTelevision(televisionInputDto);
        Television savedTelevision = televisionRepository.save(newTelevision);
        return savedTelevision.getId();
    }


    // functie voor het updaten van een televisie waarbij een dto wordt teruggegeven
    public TelevisionOutputDto updatedTelevision(Long id, TelevisionInputDto televisionInputDto) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (televisionRepository.existsById(id)) {
            Television televisionToUpdate = optionalTelevision.get();

            if (televisionInputDto.getAvailableSize() != null) {
                televisionToUpdate.setAvailableSize(televisionInputDto.getAvailableSize());
            }
            if (televisionInputDto.getAmbiLight() != null) {
                televisionToUpdate.setAmbiLight(televisionInputDto.getAmbiLight());
            }
            if (televisionInputDto.getBluetooth() != null) {
                televisionToUpdate.setBluetooth(televisionInputDto.getBluetooth());
            }
            if (televisionInputDto.getBrand() != null) {
                televisionToUpdate.setBrand(televisionInputDto.getBrand());
            }
            if (televisionInputDto.getHdr() != null) {
                televisionToUpdate.setHdr(televisionInputDto.getHdr());
            }
            if (televisionInputDto.getName() != null) {
                televisionToUpdate.setName(televisionInputDto.getName());
            }
            if (televisionInputDto.getOriginalStock() != null) {
                televisionToUpdate.setOriginalStock(televisionInputDto.getOriginalStock());
            }
            if (televisionInputDto.getPrice() != null) {
                televisionToUpdate.setPrice(televisionInputDto.getPrice());
            }
            if (televisionInputDto.getRefreshRate() != null) {
                televisionToUpdate.setRefreshRate(televisionInputDto.getRefreshRate());
            }
            if (televisionInputDto.getScreenQuality() != null) {
                televisionToUpdate.setScreenQuality(televisionInputDto.getScreenQuality());
            }
            if (televisionInputDto.getScreenType() != null) {
                televisionToUpdate.setScreenType(televisionInputDto.getScreenType());
            }
            if (televisionInputDto.getSmartTv() != null) {
                televisionToUpdate.setSmartTv(televisionInputDto.getSmartTv());
            }
            if (televisionInputDto.getSold() != null) {
                televisionToUpdate.setSold(televisionInputDto.getSold());
            }
            if (televisionInputDto.getType() != null) {
                televisionToUpdate.setType(televisionInputDto.getType());
            }
            if (televisionInputDto.getVoiceControl() != null) {
                televisionToUpdate.setVoiceControl(televisionInputDto.getVoiceControl());
            }
            if (televisionInputDto.getWifi() != null) {
                televisionToUpdate.setWifi(televisionInputDto.getWifi());
            }

            Television savedTelevision = televisionRepository.save(televisionToUpdate);
            return transfertoDto(savedTelevision);
        } else {
            throw new RecordNotFoundException("No television with id " + id);
        }
    }


    // bij DeleteMapping, functie voor het verwijderen van 1 Television, gemaakt in de les
    public String deleteById(Long id) {
        if (televisionRepository.existsById(id)) {
            Optional<Television> deletedTelevision = televisionRepository.findById(id);
            Television television1 = deletedTelevision.get();
            televisionRepository.delete(television1);
            return "Television with id: " + id + " deleted.";
        } else {
            throw new RecordNotFoundException("No television found with id: " + id + ".");
        }
    }


    public void assignRemoteControllerToTelevision(Long id, Long remoteControllerId) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        Optional<RemoteController> optionalRemotecontroller = remoteControllerRepository.findById(remoteControllerId);
        if (optionalTelevision.isPresent() && optionalRemotecontroller.isPresent()) {
            Television television = optionalTelevision.get();
            RemoteController remoteController = optionalRemotecontroller.get();
            television.setRemotecontroller(remoteController);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }


//    public void assignCIModuleToTelevision(Long id, Long CIModuleId) {
//        Optional<Television> optionalTelevision = televisionRepository.findById(id);
//        Optional<CIModule> optionalCIModule = ciModuleRepository.findById(CIModuleId);
//        if (optionalTelevision != null && optionalCIModule != null) {
//            Television television = optionalTelevision.get();
//            CIModule ciModule = optionalCIModule.get();
//            television.setCimodule(ciModule);
//            televisionRepository.save(television);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }


    // helper method from Television to Dto
    private TelevisionOutputDto transfertoDto(Television television) {
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        if (television.getRemotecontroller() != null) {
            televisionOutputDto.setRemotecontroller(television.getRemotecontroller());
        }
        if (television.getCiModules() != null) {
            televisionOutputDto.setCimodules(television.getCiModules());
        }
        televisionOutputDto.setType(television.getType());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setAvailableSize(television.getAvailableSize());
        televisionOutputDto.setRefreshRate(television.getRefreshRate());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setSmartTv(television.getSmartTv());
        televisionOutputDto.setWifi(television.getWifi());
        televisionOutputDto.setVoiceControl(television.getVoiceControl());
        televisionOutputDto.setHdr(television.getHdr());
        televisionOutputDto.setBluetooth(television.getBluetooth());
        televisionOutputDto.setAmbiLight(television.getAmbiLight());
        televisionOutputDto.setOriginalStock(television.getOriginalStock());
        televisionOutputDto.setSold(television.getSold());
        return televisionOutputDto;
    }

    //helper method from Dto to Television
    public Television transfertoTelevision(TelevisionInputDto televisionInputDto) {
        Television television = new Television();
        television.setType(televisionInputDto.getType());
        television.setName(televisionInputDto.getName());
        television.setHdr(televisionInputDto.getHdr());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setAmbiLight(televisionInputDto.getAmbiLight());
        television.setBluetooth(televisionInputDto.getBluetooth());
        television.setBrand(televisionInputDto.getBrand());
        television.setPrice(televisionInputDto.getPrice());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setSold(televisionInputDto.getSold());
        television.setType(televisionInputDto.getType());
        television.setVoiceControl(televisionInputDto.getVoiceControl());
        television.setWifi(televisionInputDto.getWifi());
        return television;
    }

    public void assignWallBracketToTelevision(Long id, Long wallBracketId) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        Optional<WallBracket> optionalWallBracket = wallBracketRepository.findById(wallBracketId);

        if (optionalTelevision.isPresent() && optionalWallBracket.isPresent()) {
            Television television = optionalTelevision.get();
            WallBracket wallBracket = optionalWallBracket.get();

            List<WallBracket> wallBracketlist = television.getWallbrackets();
            wallBracketlist.add(wallBracket);
            television.setWallbrackets(wallBracketlist);
            televisionRepository.save(television);

            List<Television> televisionlist = wallBracket.getTelevisions();
            televisionlist.add(television);
            wallBracket.setTelevisions(televisionlist);
            wallBracketRepository.save(wallBracket);

        } else {
            throw new RecordNotFoundException();

        }
    }
}


