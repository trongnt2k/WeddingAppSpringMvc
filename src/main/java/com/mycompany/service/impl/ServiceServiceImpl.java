/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.repository.ServiceRepository;
import com.mycompany.service.ServiceService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ServiceServiceImpl implements ServiceService{
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<com.mycompany.pojos.Service> getServices(String kw, int page, String priceSort) {
        return this.serviceRepository.getServices(kw, page, priceSort);
    }

    @Override
    public boolean addOrUpdate(com.mycompany.pojos.Service service) {
        try {
            Map r = this.cloudinary.uploader().upload(service.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            service.setServiceImage((String) r.get("secure_url"));
            
            return this.serviceRepository.addOrUpdate(service);          
            } catch (IOException ex) {
                System.err.println("== ADD SERVICE ==" + ex.getMessage());
            }
        
            return false;
        }

    @Override
    public long countService() {
        return this.serviceRepository.countService();
    }

    @Override
    public com.mycompany.pojos.Service getServiceById(int i) {
        return this.serviceRepository.getServiceById(i);
    }
}
