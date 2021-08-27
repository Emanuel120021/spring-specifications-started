package parnamirim.rn.users.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import parnamirim.rn.users.entities.User;
import parnamirim.rn.users.models.User_;

@Component
public class UserSpecification {

    public UserSpecification(){}

    public Specification<User> nameLike(String name){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get(User_.NAME), "%"+name+"%");
    }

    public Specification<User> getValidatedUsers(){
        return (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.isNotNull(root.get(User_.ID));
    }

}