package com.aopano.cars_demo.dao.repository;

import com.aopano.cars_demo.dao.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
