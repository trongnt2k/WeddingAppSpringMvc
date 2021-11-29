/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Menu;
import com.mycompany.repository.MenuRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Repository
@Transactional
public class MenuRepositoryImpl implements MenuRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Menu> getMenus(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery(Menu.class);
        Root root = query.from(Menu.class);
        query = query.select(root);
        if(kw!=null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        Query q = s.createQuery(query);
            
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        
        return q.getResultList();
    }

    @Override
    public long countMenu() {
        Session s = sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("Select Count(*) From Menu");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Menu> getMenus() {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery(Menu.class);
        Root root = query.from(Menu.class);
        query = query.select(root);
        
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Menu getMenuById(int menuId) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Menu.class, menuId);
    }

    @Override
    public boolean addOrUpdate(Menu menu) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.save(menu);
            return true;
        } catch(Exception ex){
            System.err.println("== ADD MENU ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
