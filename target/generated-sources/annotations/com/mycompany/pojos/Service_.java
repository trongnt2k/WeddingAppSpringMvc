package com.mycompany.pojos;

import com.mycompany.pojos.Wedding;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-29T18:18:15")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, BigDecimal> price;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, Boolean> active;
    public static volatile SingularAttribute<Service, String> serviceImage;
    public static volatile SingularAttribute<Service, Integer> id;
    public static volatile SetAttribute<Service, Wedding> wedding;

}