package novi.nl.Les11BESpringbootmodelhuiswerk.controllers;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import novi.nl.Les11BESpringbootmodelhuiswerk.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


//in Edhub sringboot 6.3 staat het anders, maar dit zie ik niet terug in het voorbeeld van de books:
//private BookService bookService;
//@Autowired
//public class BookController(BookService bookService) {
//	this.bookService = bookService;
//
//	...
//}


@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    @Autowired
    private TelevisionService televisionService;

    @GetMapping("")
    public ResponseEntity<Iterable<Television>> getTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createTelevision(@RequestBody Television television) {
        long newId = televisionService.saveTelevision(television);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // hier nog niet uitgekomen
    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable long id, @RequestBody Television television) {
        Television televisionToUpdate = televisionService.getTelevision(id);
        //hier moet nog iets tussen?
        long newId = televisionService.saveTelevision(television);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTelevision(@PathVariable long id) {
        televisionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/pricesUnder")
//    public ResponseEntity<Iterable<Television>> getTelevisionsUnderPrice(@RequestParam double price) {
//        return ResponseEntity.ok(televisionService.findByPriceLessThan(price));
//    }
//
//    @GetMapping("/byBrand")
//    public ResponseEntity<Iterable<Television>> getTelevisionsByBrand(@RequestParam String brand) {
//        return ResponseEntity.ok(televisionService.findByBrand(brand));
//    }
}


