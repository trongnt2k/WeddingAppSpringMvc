/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Menu;
import com.mycompany.repository.MenuRepository;
import com.mycompany.service.MenuService;
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
public class MenuServiceImpl implements MenuService{
    @Autowired
    public MenuRepository menuRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Menu> getMenus(String kw, int page) {
        return this.menuRepository.getMenus(kw, page);
    }

    @Override
    public long countMenu() {
        return this.menuRepository.countMenu();
    }

    @Override
    public List<Menu> getMenus() {
        return this.menuRepository.getMenus();
    }

    @Override
    public Menu getMenuById(int menuId) {
        return this.menuRepository.getMenuById(menuId);
    }

    @Override
    public boolean addOrUpdate(Menu menu) {
        try {
            Map r = this.cloudinary.uploader().upload(menu.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            menu.setMenuImages((String) r.get("secure_url"));
            
            return this.menuRepository.addOrUpdate(menu);          
            } catch (IOException ex) {
                System.err.println("== ADD MENU ==" + ex.getMessage());
            }
        
            return false;
    }
}
