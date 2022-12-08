package novi.nl.Les11BESpringbootmodelhuiswerk.outputDto;

import lombok.Getter;
import lombok.Setter;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;
import java.util.List;

@Getter
@Setter

public class WallBracketOutputDto {
//    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;
    private List<Television> televisions;


}
