package novi.nl.Les11BESpringbootmodelhuiswerk.dto;

import novi.nl.Les11BESpringbootmodelhuiswerk.models.Television;

// we hebben in deze opdracht een tvdto en tvinputdto om te laten zien dat dit kan maar ze zijn beide in dit geval hetzelfde. Je kan meerdere dto's gebruiken, bijv een dto waarin je alleen je password verifieert en niet alle usergegevens in staan en dus een dto met je usergegevens.

public class TelevisionDto {
    //id wordt automatisch gegenereerd, dus hoeft hier niet
    //    public long id;
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

    // getters & setters...............................................
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Integer getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Integer availableSize) {
        this.availableSize = availableSize;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean isWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean isHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
