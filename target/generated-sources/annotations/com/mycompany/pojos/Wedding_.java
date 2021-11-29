package com.mycompany.pojos;

import com.mycompany.pojos.Comment;
import com.mycompany.pojos.Menu;
import com.mycompany.pojos.Service;
import com.mycompany.pojos.User;
import com.mycompany.pojos.WeddingHall;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T18:18:15")
@StaticMetamodel(Wedding.class)
public class Wedding_ { 

    public static volatile SingularAttribute<Wedding, WeddingHall> weddinghall;
    public static volatile SingularAttribute<Wedding, BigDecimal> totalPrice;
    public static volatile SingularAttribute<Wedding, Date> organizeDate;
    public static volatile SetAttribute<Wedding, Service> service;
    public static volatile CollectionAttribute<Wedding, Comment> commentCollection;
    public static volatile SingularAttribute<Wedding, String> description;
    public static volatile SingularAttribute<Wedding, Integer> numberDesk;
    public static volatile SingularAttribute<Wedding, Integer> id;
    public static volatile SingularAttribute<Wedding, Menu> menu;
    public static volatile SingularAttribute<Wedding, User> user;

}