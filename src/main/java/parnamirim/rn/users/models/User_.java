package parnamirim.rn.users.models;


import parnamirim.rn.users.entities.User;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

    public static volatile SingularAttribute<User, String> id;
    public  static volatile SingularAttribute<User, String> nome;
    public static volatile SingularAttribute<User, Integer> idade;

    public static final String ID= "id";
    public static final String  NAME="nome";
    public static final String IDADE="idade";
}
