/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@Entity
@Table(name = "dishesanddrink")
public class Dishesanddrink implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 150, min = 5, message = "{dishesanddrink.name.lenErr}")
    private String name;
    @Column(name = "dishes_drink_images")
    private String dishesDrinkImages;
    @Max(value = 10000000, message = "{dishesanddrink.price.maxErr}")
    @Min(value = 3000, message = "{dishesanddrink.price.minErr}")
    private BigDecimal price;
    private Boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="menu_dishesanddrink",
            joinColumns = { @JoinColumn(name = "dishesanddrink_id") },
            inverseJoinColumns = { @JoinColumn(name = "menu_id") }
    )
    private Set<Menu> menu;
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
     * @return the dishesDrinkImages
     */
    public String getDishesDrinkImages() {
        return dishesDrinkImages;
    }

    /**
     * @param dishesDrinkImages the dishesDrinkImages to set
     */
    public void setDishesDrinkImages(String dishesDrinkImages) {
        this.dishesDrinkImages = dishesDrinkImages;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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

    /**
     * @return the menu
     */
    public Set<Menu> getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }
    
}
