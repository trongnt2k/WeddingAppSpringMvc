package com.mycompany.pojos;

import com.mycompany.pojos.Wedding;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-08T09:43:39")
@StaticMetamodel(WeddingHall.class)
public class WeddingHall_ { 

    public static volatile SingularAttribute<WeddingHall, String> weddingHallImages;
    public static volatile SingularAttribute<WeddingHall, BigDecimal> weddingHallPrice;
    public static volatile SingularAttribute<WeddingHall, String> timeWedding;
    public static volatile SingularAttribute<WeddingHall, String> name;
    public static volatile SingularAttribute<WeddingHall, String> description;
    public static volatile SingularAttribute<WeddingHall, Boolean> active;
    public static volatile SingularAttribute<WeddingHall, String> location;
    public static volatile SingularAttribute<WeddingHall, Integer> id;
    public static volatile SetAttribute<WeddingHall, Wedding> wedding;

}