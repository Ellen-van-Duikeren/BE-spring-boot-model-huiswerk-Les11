package novi.nl.Les11BESpringbootmodelhuiswerk.outputDto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.Setter;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.CIModule;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.RemoteController;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.WallBracket;

import java.util.List;

// we hebben in deze opdracht een tvdto en tvinputdto om te laten zien dat dit kan maar ze zijn beide in dit geval hetzelfde. Je kan meerdere dto's gebruiken, bijv een dto waarin je alleen je password verifieert en niet alle usergegevens in staan en dus een dto met je usergegevens.

@Getter
@Setter

public class TelevisionOutputDto {
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
    @JsonIncludeProperties("id")
    private RemoteController remotecontroller;

//    @JsonIncludeProperties("id")
//    private CIModule cimodule;

    @JsonIncludeProperties("id")
    private List<CIModule> cimodules;

    @JsonIncludeProperties("id")
    private List<WallBracket> wallbrackets;

}
