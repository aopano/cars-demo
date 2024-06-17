package com.aopano.cars_demo.service.impl;

import com.aopano.cars_demo.dao.model.Car;
import com.aopano.cars_demo.dao.repository.CarRepository;
import com.aopano.cars_demo.dto.CarDTO;
import com.aopano.cars_demo.service.api.CarDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDataServiceJPA implements CarDataService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDTO> findCars(CarDTO filter) {

        List<CarDTO> carsList = new ArrayList<>();

        if (filter == null) {

            carsList = carRepository.findAll().stream().toList()
                    .stream().map(car -> (new CarDTO()).map(car)).toList();

        } else {

            Car carFilter = filter.extract();

            carsList = carRepository.findAll(Example.of(carFilter)).stream().toList()
                    .stream().map(car -> (new CarDTO()).map(car)).toList();
        }

        return carsList;
    }
}
