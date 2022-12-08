package novi.nl.Les11BESpringbootmodelhuiswerk.outputDto;

import lombok.Getter;
import lombok.Setter;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;

@Getter
@Setter
public class CIModuleOutputDto {
//    private Long id;
    private String name;
    private String type;
    private Double price;
    private Television television;

}
