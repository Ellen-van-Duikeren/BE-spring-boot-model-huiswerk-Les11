package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "remotecontrollers")
public class RemoteController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;

    //    Een OneToOne relatie tussen Television en RemoteController
    @OneToOne(mappedBy = "remotecontroller")
    private Television television;

}