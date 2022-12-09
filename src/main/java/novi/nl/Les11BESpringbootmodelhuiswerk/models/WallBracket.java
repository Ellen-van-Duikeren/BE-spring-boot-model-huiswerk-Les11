package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "wallbrackets")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    //    Een ManyToMany relatie tussen Television en WallBracket
    @ManyToMany(mappedBy = "wallbrackets")
    @JsonIgnore
    private List<Television> televisions;

}
