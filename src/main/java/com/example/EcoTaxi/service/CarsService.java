package com.example.EcoTaxi.service;

import com.example.EcoTaxi.entity.Cars;
import com.example.EcoTaxi.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    public List<Cars> getAllCars(){
        return carsRepository.findAll();
    }

    public Cars saveCars(Cars cars){
        return carsRepository.save(cars);
    }

    public void deleteCars(Long id){
        carsRepository.deleteById(id);
    }

    public Cars updateCars(Long id, Cars updatedCars){
        Optional<Cars> existingCar = carsRepository.findById(id);
        if (existingCar.isPresent()) {
            Cars cars = existingCar.get();
            cars.setDriverName(updatedCars.getDriverName());
            cars.setNumber(updatedCars.getNumber());
            cars.setLicensePlate(updatedCars.getLicensePlate());
            cars.setLatitude(updatedCars.getLatitude());
            cars.setLongitude(updatedCars.getLongitude());
            return carsRepository.save(cars);
        } else {
            return null;
        }
    }
}
