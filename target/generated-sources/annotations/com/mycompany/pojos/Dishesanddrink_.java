package com.mycompany.pojos;

import com.mycompany.pojos.Menu;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T09:31:58")
@StaticMetamodel(Dishesanddrink.class)
public class Dishesanddrink_ { 

    public static volatile SingularAttribute<Dishesanddrink, String> dishesDrinkImages;
    public static volatile SingularAttribute<Dishesanddrink, BigDecimal> price;
    public static volatile SingularAttribute<Dishesanddrink, String> name;
    public static volatile SingularAttribute<Dishesanddrink, Boolean> active;
    public static volatile SingularAttribute<Dishesanddrink, Integer> id;
    public static volatile SetAttribute<Dishesanddrink, Menu> menu;

}