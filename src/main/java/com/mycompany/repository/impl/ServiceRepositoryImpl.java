/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Service;
import com.mycompany.repository.ServiceRepository;
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
public class ServiceRepositoryImpl implements ServiceRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Service> getServices(String kw, int page, String priceSort) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Service> query = builder.createQuery(Service.class);
        Root root = query.from(Service.class);
        query = query.select(root);
        if(kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
               query = query.where(p);
        }
        if(priceSort.equals("pri-incr") == true){
            query = query.orderBy(builder.asc(root.get("price")));
        }
        if(priceSort.equals("pri-decr") == true){
            query = query.orderBy(builder.desc(root.get("price")));
        }
        Query q = s.createQuery(query);
        
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page-1) * max);
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Service service) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try{
            s.save(service);
            return true;
        } catch(Exception ex){
            System.err.println("== ADD SERVICE ==" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public long countService() {
        Session s = sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("Select Count(*) From Service");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Service getServiceById(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Service.class, i);
    }
    
}
