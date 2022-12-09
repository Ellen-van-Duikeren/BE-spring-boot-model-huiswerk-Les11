package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Integer availableSize;
    private Integer refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;


    // Een OneToOne relatie tussen Television en RemoteController
    @OneToOne
    private RemoteController remotecontroller;

    // Een ManyToOne relatie tussen Television en CI-Module
    // @ManyToOne
    // private CIModule cimodule;

    // Een OneToMany relatie tussen Television en CI-Module
    @OneToMany(mappedBy = "television")
    // @JsonIgnore als ik deze uitcomment dan werkt de getAllCiModules niet meer
    private List<CIModule> cimodules;

    // Een ManyToMany relatie tussen Television en WallBracket
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "television_id"), inverseJoinColumns = @JoinColumn(name = "wallbracket_id"))
    private List<WallBracket> wallbrackets;

    public void addWallBracket(WallBracket wallBracket) {
        this.wallbrackets.add(wallBracket);
    }

}
