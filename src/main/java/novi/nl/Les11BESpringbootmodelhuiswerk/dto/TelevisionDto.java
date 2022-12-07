package novi.nl.Les11BESpringbootmodelhuiswerk.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.CIModule;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.RemoteController;
import novi.nl.Les11BESpringbootmodelhuiswerk.models.WallBracket;

import java.util.List;

// we hebben in deze opdracht een tvdto en tvinputdto om te laten zien dat dit kan maar ze zijn beide in dit geval hetzelfde. Je kan meerdere dto's gebruiken, bijv een dto waarin je alleen je password verifieert en niet alle usergegevens in staan en dus een dto met je usergegevens.

public class TelevisionDto {
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

    // getters & setters...............................................

//    public List<CIModule> getCimodules() {
//        return cimodules;
//    }
//
//    public void setCimodules(List<CIModule> cimodules) {
//        this.cimodules = cimodules;
//    }

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

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
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

    public RemoteController getRemotecontroller() {
        return remotecontroller;
    }

    public void setRemotecontroller(RemoteController remotecontroller) {
        this.remotecontroller = remotecontroller;
    }

    public List<CIModule> getCimodules() {
        return cimodules;
    }

    public void setCimodules(List<CIModule> cimodules) {
        this.cimodules = cimodules;
    }

    //    public List<WallBracket> getWallBrackets() {
//        return wallBrackets;
//    }
//
//    public void setWallBrackets(List<WallBracket> wallBrackets) {
//        this.wallBrackets = wallBrackets;
//    }
}
