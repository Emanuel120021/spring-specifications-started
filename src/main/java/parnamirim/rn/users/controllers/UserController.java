package parnamirim.rn.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parnamirim.rn.users.entities.User;
import parnamirim.rn.users.models.User_;
import parnamirim.rn.users.repositories.UserRepository;
import parnamirim.rn.users.specifications.UserSpecification;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserSpecification userSpecification;

    @GetMapping(path = "/user")
    public List<User> getSpecificUser(@RequestParam("nome") String name){
        List<User> listUsers = userRepository.findAll(userSpecification.nameLike(name));
        return listUsers;
    }

    @GetMapping(path = "/users")
    public Page<User> getUsers(@RequestParam(name="page",defaultValue="0") Integer page,
                               @RequestParam(name="size",defaultValue="5",required=false) Integer size,
                               @RequestParam(name="sort",defaultValue="asc",required=false) String sort){
        PageRequest pageRequest = PageRequest.of(page,size);
        if(sort.equals("desc")) pageRequest = PageRequest.of(page, size, Sort.by(User_.IDADE).descending());
        Page<User> listUsers = userRepository.findAll(userSpecification.getValidatedUsers(),pageRequest);

        return listUsers;
    }

}
