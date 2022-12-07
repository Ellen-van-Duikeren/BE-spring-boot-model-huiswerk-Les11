package novi.nl.Les11BESpringbootmodelhuiswerk.inputDto;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;

import java.util.List;

public class WallBracketInputDto {
    private String size;
    private Boolean ajustable;
    private String name;
    private Double price;
    private List<Television> televisions;

    //    getters & setters ...................................

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAjustable() {
        return ajustable;
    }

    public void setAjustable(Boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }
}
