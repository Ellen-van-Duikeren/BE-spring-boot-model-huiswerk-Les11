package novi.nl.Les11BESpringbootmodelhuiswerk.outputDto;

import lombok.Getter;
import lombok.Setter;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;

@Getter
@Setter
public class RemoteControllerOutputDto {
//    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;
    private Television television;


}
