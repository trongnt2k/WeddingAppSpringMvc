/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@Table(name="wedding")
public class Wedding implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number_desk")
    private int numberDesk;
    @Column(name = "organize_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date organizeDate;
    private String description;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "weddinghall_id")
    private WeddingHall weddinghall;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "wedding_service",
            joinColumns = { @JoinColumn(name="wedding_id") },
            inverseJoinColumns = { @JoinColumn(name="service_id") }
    )
    private Set<Service> service;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wedding", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;

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
     * @return the numberDesk
     */
    public int getNumberDesk() {
        return numberDesk;
    }

    /**
     * @param numberDesk the numberDesk to set
     */
    public void setNumberDesk(int numberDesk) {
        this.numberDesk = numberDesk;
    }

    /**
     * @return the organizeDate
     */
    public Date getOrganizeDate() {
        return organizeDate;
    }

    /**
     * @param organizeDate the organizeDate to set
     */
    public void setOrganizeDate(Date organizeDate) {
        this.organizeDate = organizeDate;
    }

    /**
     * @return the totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the weddinghall
     */
    public WeddingHall getWeddinghall() {
        return weddinghall;
    }

    /**
     * @param weddinghall the weddinghall to set
     */
    public void setWeddinghall(WeddingHall weddinghall) {
        this.weddinghall = weddinghall;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @return the service
     */
    public Set<Service> getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Set<Service> service) {
        this.service = service;
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
     * @return the commentCollection
     */
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    /**
     * @param commentCollection the commentCollection to set
     */
    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
}
