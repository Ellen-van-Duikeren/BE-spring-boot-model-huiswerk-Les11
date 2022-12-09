package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "cimodules")
public class CIModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private Double price;

    //    Een ManyToOne relatie tussen Television en CI-Module
    //    @OneToMany(mappedBy = "cimodule")
    //    private List<Television> televisions;


    //    OneToMany relatie tussen Television en CI-Module
    @ManyToOne
    private Television television;

}

