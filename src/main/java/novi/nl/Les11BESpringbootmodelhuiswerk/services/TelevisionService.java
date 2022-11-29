package novi.nl.Les11BESpringbootmodelhuiswerk.services;

import novi.nl.Les11BESpringbootmodelhuiswerk.dto.TelevisionDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.dto.TelevisionInputDto;
import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository repository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.repository = televisionRepository;
    }


    // GetMapping, functie voor het ophalen van alle Televisions
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = repository.findAll();
        ArrayList<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television television : televisions) {
            TelevisionDto televisionDto = transfertoDto(television);
            televisionDtos.add(televisionDto);
        }
        return televisionDtos;
    }

    // GetMapping by id, functie voor het ophalen van 1 Television, cf hw klas
    public TelevisionDto getTelevision(Long id) {
        Optional<Television> optionalTelevision = repository.findById(id);
        if (!repository.existsById(id)) {
            throw new RecordNotFoundException("No television found with id: " + id + ".");
        } else {
            Television television1 = optionalTelevision.get();
            return transfertoDto(television1);
        }
    }

    //     PostMapping, functie voor het opslaan van 1 Television, nog aanpassen, in de les gemaakt
    public Long createTelevision(TelevisionInputDto televisionInputDto) {
        Television newTelevision = new Television();
        newTelevision = transfertoTelevision(televisionInputDto);
        Television savedTelevision = repository.save(newTelevision);
        return savedTelevision.getId();
    }

//    cf in de les
//    bij PutMapping, functie voor het updaten van 1 Television
//    public Long updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
//        Optional<Television> optionalTelevision = repository.findById(id);
//        if (repository.existsById(id)) {
//            Television televisionToUpdate = optionalTelevision.get();
//
//            if (televisionInputDto.getAvailableSize() != null) {
//                televisionToUpdate.setAvailableSize(televisionInputDto.getAvailableSize());
//            }
//            if (televisionInputDto.isAmbiLight() != null) {
//                televisionToUpdate.setAmbiLight(televisionInputDto.isAmbiLight());
//            }
//            if (televisionInputDto.isBluetooth() != null) {
//                televisionToUpdate.setBluetooth(televisionInputDto.isBluetooth());
//            }
//            if (televisionInputDto.getBrand() != null) {
//                televisionToUpdate.setBrand(televisionInputDto.getBrand());
//            }
//            if (televisionInputDto.isHdr() != null ) {
//                televisionToUpdate.setHdr(televisionInputDto.isHdr());
//            }
//            if (televisionInputDto.getName() != null) {
//                televisionToUpdate.setName(televisionInputDto.getName());
//            }
//            if (televisionInputDto.getOriginalStock() != null) {
//                televisionToUpdate.setOriginalStock(televisionInputDto.getOriginalStock());
//            }
//            if (televisionInputDto.getPrice() != null) {
//                televisionToUpdate.setPrice(televisionInputDto.getPrice());
//            }
//            if (televisionInputDto.getRefreshRate() != null) {
//                televisionToUpdate.setRefreshRate(televisionInputDto.getRefreshRate());
//            }
//            if (televisionInputDto.getScreenQuality() != null) {
//                televisionToUpdate.setScreenQuality(televisionInputDto.getScreenQuality());
//            }
//            if (televisionInputDto.getScreenType() != null) {
//                televisionToUpdate.setScreenType(televisionInputDto.getScreenType());
//            }
//            if (televisionInputDto.isSmartTv() != null) {
//                televisionToUpdate.setSmartTv(televisionInputDto.isSmartTv());
//            }
//            if (televisionInputDto.getSold() != null) {
//                televisionToUpdate.setSold(televisionInputDto.getSold());
//            }
//            if (televisionInputDto.getType() != null) {
//                televisionToUpdate.setType(televisionInputDto.getType());
//            }
//            if (televisionInputDto.isVoiceControl() != null) {
//                televisionToUpdate.setVoiceControl(televisionInputDto.isVoiceControl());
//            }
//            if (televisionInputDto.isWifi() != null) {
//                televisionToUpdate.setWifi(televisionInputDto.isWifi());
//            }
//
//            Television savedTelevision = repository.save(televisionToUpdate);
//            return savedTelevision.getId();
//        } else {
//            throw new RecordNotFoundException("No television with id " + id);
//        }
//    }


    // functie voor het updaten van een televisie waarbij een dto wordt teruggegeven
    public TelevisionDto updatedTelevision(Long id, TelevisionInputDto televisionInputDto) {
        Optional<Television> optionalTelevision = repository.findById(id);
        if (repository.existsById(id)) {
            Television televisionToUpdate = optionalTelevision.get();

            if (televisionInputDto.getAvailableSize() != null) {
                televisionToUpdate.setAvailableSize(televisionInputDto.getAvailableSize());
            }
            if (televisionInputDto.isAmbiLight() != null) {
                televisionToUpdate.setAmbiLight(televisionInputDto.isAmbiLight());
            }
            if (televisionInputDto.isBluetooth() != null) {
                televisionToUpdate.setBluetooth(televisionInputDto.isBluetooth());
            }
            if (televisionInputDto.getBrand() != null) {
                televisionToUpdate.setBrand(televisionInputDto.getBrand());
            }
            if (televisionInputDto.isHdr() != null) {
                televisionToUpdate.setHdr(televisionInputDto.isHdr());
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
            if (televisionInputDto.isSmartTv() != null) {
                televisionToUpdate.setSmartTv(televisionInputDto.isSmartTv());
            }
            if (televisionInputDto.getSold() != null) {
                televisionToUpdate.setSold(televisionInputDto.getSold());
            }
            if (televisionInputDto.getType() != null) {
                televisionToUpdate.setType(televisionInputDto.getType());
            }
            if (televisionInputDto.isVoiceControl() != null) {
                televisionToUpdate.setVoiceControl(televisionInputDto.isVoiceControl());
            }
            if (televisionInputDto.isWifi() != null) {
                televisionToUpdate.setWifi(televisionInputDto.isWifi());
            }

            Television savedTelevision = repository.save(televisionToUpdate);
            return transfertoDto(savedTelevision);
        } else {
            throw new RecordNotFoundException("No television with id " + id);
        }
    }

    // bij DeleteMapping, functie voor het verwijderen van 1 Television, gemaakt in de les
    public String deleteById(Long id) {
        if (repository.existsById(id)) {
            Optional<Television> deletedTelevision = repository.findById(id);
            Television television1 = deletedTelevision.get();
            repository.delete(television1);
            return "Television with id: " + id + " deleted.";
        } else {
            throw new RecordNotFoundException("No television found with id: " + id + ".");
        }
    }

    // helper method from Television to Dto
    private TelevisionDto transfertoDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.setType(television.getType());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setName(television.getName());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.isSmartTv());
        televisionDto.setWifi(television.isWifi());
        televisionDto.setVoiceControl(television.isVoiceControl());
        televisionDto.setHdr(television.isHdr());
        televisionDto.setBluetooth(television.isBluetooth());
        televisionDto.setAmbiLight(television.isAmbiLight());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());
        return televisionDto;
    }

    //helper method from Dto to Television
    public Television transfertoTelevision(TelevisionInputDto televisionInputDto) {
        Television television = new Television();
        television.setType(televisionInputDto.getType());
        television.setName(televisionInputDto.getName());
        television.setHdr(televisionInputDto.isHdr());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setAmbiLight(televisionInputDto.isAmbiLight());
        television.setBluetooth(televisionInputDto.isBluetooth());
        television.setBrand(televisionInputDto.getBrand());
        television.setPrice(televisionInputDto.getPrice());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setSmartTv(televisionInputDto.isSmartTv());
        television.setSold(televisionInputDto.getSold());
        television.setType(televisionInputDto.getType());
        television.setVoiceControl(televisionInputDto.isVoiceControl());
        television.setWifi(televisionInputDto.isWifi());
        return television;
    }
}


