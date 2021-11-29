/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.pojos.Service;
import java.util.List;

/**
 *
 * @author User
 */
public interface ServiceRepository {
    List<Service> getServices(String kw, int page, String priceSort);
    boolean addOrUpdate(Service service);
    long countService();
    Service getServiceById(int serviceId);
}
