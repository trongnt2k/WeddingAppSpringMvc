package com.mycompany.pojos;

import com.mycompany.pojos.User;
import com.mycompany.pojos.Wedding;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-08T09:43:39")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> createdDate;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, Wedding> wedding;
    public static volatile SingularAttribute<Comment, User> user;
    public static volatile SingularAttribute<Comment, String> content;

}