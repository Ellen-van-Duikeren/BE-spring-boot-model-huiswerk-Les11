package novi.nl.Les11BESpringbootmodelhuiswerk.inputDto;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;

public class CIModuleInputDto {
    private String name;
    private String type;
    private Double price;
    private Television television;




    // getters & setters
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

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
