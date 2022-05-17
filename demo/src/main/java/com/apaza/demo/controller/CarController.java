package com.apaza.demo.controller;


import com.apaza.demo.entity.Car;
import com.apaza.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<Car>> listado(){
        List<Car> car = service.listar();
        if (car.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getId(@PathVariable Long id){
        Car car = service.getCarId(id);
        if (car ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        Car carNew = service.save(car);
        return ResponseEntity.ok(carNew);
    }

    @GetMapping("/byUser/{id}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable Long id){
        List<Car> car = service.byUserCar(id);
        if (car.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(car);
    }









}
