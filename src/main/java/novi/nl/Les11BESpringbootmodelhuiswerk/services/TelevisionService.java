package novi.nl.Les11BESpringbootmodelhuiswerk.services;

import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    @Autowired
    private TelevisionRepository televisionRepository;

    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            return optionalTelevision.get();
        } else {
            throw new RecordNotFoundException("No television with id " + id);
        }
    }

    // bij PostMapping
    public long saveTelevision(Television television) {
        Television saved = televisionRepository.save(television);
        return saved.getId();
    }

    // bij PutMapping, zelf bedacht want geen example in books
    public long updateTelevision(long id, Television television) {
        if (televisionRepository.existsById(id)) {
            Television saved = televisionRepository.save(television);
            return saved.getId();
        } else {
            throw new RecordNotFoundException("No television with id " + id);
        }
    }

    // bij DeleteMapping
    public void deleteById(long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No television with id " + id);
        }
    }


}


