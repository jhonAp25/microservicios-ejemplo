package com.example.usermicro.controller;


import com.example.usermicro.entity.User;
import com.example.usermicro.model.Car;
import com.example.usermicro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listado(){

        List<User> user = service.listar();
        if (user.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id") Long id){
        User user = service.getUserId(id);
        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }



    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = service.saveUser(user);

        return ResponseEntity.ok(userNew);
    }


    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") Long userId  ){
        User user = service.getUserId(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Car> cars =service.getCar(userId);

        return ResponseEntity.ok(cars);
    }

}
