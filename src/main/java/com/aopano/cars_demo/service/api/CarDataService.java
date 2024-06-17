package com.aopano.cars_demo.service.api;

import com.aopano.cars_demo.dto.CarDTO;

import java.util.List;

public interface CarDataService {

    List<CarDTO> findCars(CarDTO filter);
}
