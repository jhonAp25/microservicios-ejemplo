package com.example.usermicro.service;

import com.example.usermicro.entity.User;
import com.example.usermicro.model.Car;
import com.example.usermicro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> listar(){
        return repository.findAll();
    }
    public User getUserId(Long id){
        return repository.findById(id).orElse(null);
    }

    public  User saveUser(User user){
        return repository.save(user);
    }



    public List<Car> getCar(Long id){
        List<Car> cars= restTemplate.getForObject("http://localhost:8080/car/byUser/"+ id, List.class);

        return cars;
    }


}
