/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class Cart {
    private int weddingHallId;
    private String weddingHallName;
    private int serviceId;
    private String serviceName;
    private int menuId;
    private String menuName;
    private BigDecimal price;
    private int count;

    /**
     * @return the weddingHallId
     */
    public int getWeddingHallId() {
        return weddingHallId;
    }

    /**
     * @param weddingHallId the weddingHallId to set
     */
    public void setWeddingHallId(int weddingHallId) {
        this.weddingHallId = weddingHallId;
    }

    /**
     * @return the weddingHallName
     */
    public String getWeddingHallName() {
        return weddingHallName;
    }

    /**
     * @param weddingHallName the weddingHallName to set
     */
    public void setWeddingHallName(String weddingHallName) {
        this.weddingHallName = weddingHallName;
    }

    /**
     * @return the serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the menuId
     */
    public int getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

   
}
