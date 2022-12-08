package novi.nl.Les11BESpringbootmodelhuiswerk.inputDto;

import lombok.Getter;
import lombok.Setter;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.WallBracket;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class TelevisionInputDto {
    @NotBlank
    public String type;
    public String brand;
    @NotBlank
    @Size(min = 4, max = 30)
    public String name;
    @PositiveOrZero
    public Double price;
    public Integer availableSize;
    public Integer refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

    public List<WallBracket> wallbrackets;




}


