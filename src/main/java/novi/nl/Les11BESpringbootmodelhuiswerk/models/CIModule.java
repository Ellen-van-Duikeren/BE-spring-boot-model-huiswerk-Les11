package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    //getters & setters........................................
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // hoort bij ManyToOne
    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }

    // hoort bij OneToMany
//    public List<Television> getTelevisions() {
//        return televisions;
//    }
//
//    public void setTelevisions(List<Television> televisions) {
//        this.televisions = televisions;
//    }
}

