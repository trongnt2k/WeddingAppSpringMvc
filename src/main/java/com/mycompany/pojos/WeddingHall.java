/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@Entity
@Table(name= "weddinghall")
public class WeddingHall implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "{weddinghall.name.nullErr}")
    @Size(min=2, max=150, message="{weddinghall.name.lenErr}")
    private String name;
    @Size(min=2, max=15, message="{weddinghall.timeWedding.lenErr}")
    @NotNull(message = "{weddinghall.timeWedding.nullErr}")
    @Column(name = "time_wedding")
    private String timeWedding;
    @Column(name = "wedding_hall_images")
    private String weddingHallImages;
    private String location;
    @NotNull(message = "{weddinghall.weddingHallPrice.nullErr}")
    @Min(value=1000000, message = "{weddinghall.weddingHallPrice.minErr}")
    @Max(value=100000000, message = "{weddinghall.weddingHallPrice.maxErr}")
    @Column(name = "wedding_hall_price")
    private BigDecimal weddingHallPrice;
    private String description;
    private Boolean active;
    @OneToMany(mappedBy = "weddinghall")
    private Set<Wedding> wedding;
    @Transient
    private MultipartFile file;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the timeWedding
     */
    public String getTimeWedding() {
        return timeWedding;
    }

    /**
     * @param timeWedding the timeWedding to set
     */
    public void setTimeWedding(String timeWedding) {
        this.timeWedding = timeWedding;
    }

    /**
     * @return the weddingHallImages
     */
    public String getWeddingHallImages() {
        return weddingHallImages;
    }

    /**
     * @param weddingHallImages the weddingHallImages to set
     */
    public void setWeddingHallImages(String weddingHallImages) {
        this.weddingHallImages = weddingHallImages;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the weddingHallPrice
     */
    public BigDecimal getWeddingHallPrice() {
        return weddingHallPrice;
    }

    /**
     * @param weddingHallPrice the weddingHallPrice to set
     */
    public void setWeddingHallPrice(BigDecimal weddingHallPrice) {
        this.weddingHallPrice = weddingHallPrice;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the wedding
     */
    public Set<Wedding> getWedding() {
        return wedding;
    }

    /**
     * @param wedding the wedding to set
     */
    public void setWedding(Set<Wedding> wedding) {
        this.wedding = wedding;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
