/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.CascadeType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 150, min = 5, message = "{menu.name.lenErr}")
    private String name;
    @Column(name = "menu_images")
    private String menuImages;
    @Transient
    private BigDecimal totalMoney;
    //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="menu_dishesanddrink",
            joinColumns = { @JoinColumn(name = "menu_id") },
            inverseJoinColumns = { @JoinColumn(name = "dishesanddrink_id") }
    )
    private Set<Dishesanddrink> dishesanddrink;
    @OneToMany(mappedBy = "menu")
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
     * @return the menuImages
     */
    public String getMenuImages() {
        return menuImages;
    }

    /**
     * @param menuImages the menuImages to set
     */
    public void setMenuImages(String menuImages) {
        this.menuImages = menuImages;
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
    

    /**
     * @return the totalMoney
     */
    public BigDecimal getTotalMoney() {
        List<Dishesanddrink> dad = new ArrayList<Dishesanddrink>(this.getDishesanddrink());
        Long total = 0l;
        for(int i=0; i<dad.size(); i++){
            total += dad.get(i).getPrice().intValue();
        }
        
        BigDecimal b = new BigDecimal(total);
        return b;
    }

    /**
     * @param totalMoney the totalMoney to set
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * @return the dishesanddrink
     */
    public Set<Dishesanddrink> getDishesanddrink() {
        return dishesanddrink;
    }

    /**
     * @param dishesanddrink the dishesanddrink to set
     */
    public void setDishesanddrink(Set<Dishesanddrink> dishesanddrink) {
        this.dishesanddrink = dishesanddrink;
    }

    
    
}
