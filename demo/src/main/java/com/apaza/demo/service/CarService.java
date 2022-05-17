package com.apaza.demo.service;


import com.apaza.demo.entity.Car;
import com.apaza.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;


    public List<Car> listar(){
        return repository.findAll();
    }

    public Car save (Car car){
        return repository.save(car);
    }

    public Car getCarId (Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Car> byUserCar (Long id ){
        return repository.findByUserId(id );
    }

    public String update(Car car, Long id){
        Car carNew = repository.getById(id);

        carNew.setMarca(car.getMarca());
        carNew.setDescripcion(car.getDescripcion());

        repository.save(carNew);
        return "Auto \""+car.getMarca()+"\" actualizado.";
    }




}
