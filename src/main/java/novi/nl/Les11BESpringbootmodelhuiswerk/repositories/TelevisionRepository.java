package novi.nl.Les11BESpringbootmodelhuiswerk.repositories;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
   }
