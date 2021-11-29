package com.mycompany.pojos;

import com.mycompany.pojos.Dishesanddrink;
import com.mycompany.pojos.Wedding;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T18:18:15")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SetAttribute<Menu, Dishesanddrink> dishesanddrink;
    public static volatile SingularAttribute<Menu, String> name;
    public static volatile SingularAttribute<Menu, String> menuImages;
    public static volatile SingularAttribute<Menu, Integer> id;
    public static volatile SetAttribute<Menu, Wedding> wedding;

}