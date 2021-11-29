/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojos.Menu;
import java.util.List;

/**
 *
 * @author User
 */
public interface MenuService {
    List <Menu> getMenus(String kw, int page);
    List <Menu> getMenus();
    long countMenu();
    Menu getMenuById(int menuId);
    boolean addOrUpdate(Menu menu);
}
