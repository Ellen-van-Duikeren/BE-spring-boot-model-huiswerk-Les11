package novi.nl.Les11BESpringbootmodelhuiswerk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import novi.nl.Les11BESpringbootmodelhuiswerk.exceptions.RecordNotFoundException;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.TelevisionRepository;
import novi.nl.Les11BESpringbootmodelhuiswerk.repositories.WallBracketRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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


    //    Een OneToOne relatie tussen Television en RemoteController
    @OneToOne
    private RemoteController remotecontroller;

    //    Een ManyToOne relatie tussen Television en CI-Module
//    @ManyToOne
//    private CIModule cimodule;

//    Een OneToMany relatie tussen Television en CI-Module
    @OneToMany(mappedBy = "television")
    @JsonIgnore
    private List<CIModule> ciModules;

//        Een ManyToMany relatie tussen Television en WallBracket
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "television_id"), inverseJoinColumns = @JoinColumn(name = "wallbracket_id"))
    private List<WallBracket> wallbrackets;


    // getters & setters
    public List<CIModule> getCiModules() {
        return ciModules;
    }

    public void setCiModules(List<CIModule> ciModules) {
        this.ciModules = ciModules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public CIModule getCimodule() {
//        return cimodule;
//    }
//
//    public void setCimodule(CIModule cimodule) {
//        this.cimodule = cimodule;
//    }



    public List<WallBracket> getWallbrackets() {
        return wallbrackets;
    }

    public void setWallbrackets(List<WallBracket> wallbrackets) {
        this.wallbrackets = wallbrackets;
    }
}
