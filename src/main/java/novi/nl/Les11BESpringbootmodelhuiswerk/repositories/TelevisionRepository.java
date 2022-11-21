package novi.nl.Les11BESpringbootmodelhuiswerk.repositories;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    public Iterable<Television> findByPriceLessThan(double price);
    public Iterable<Television> findByBrand(String brand);


}
