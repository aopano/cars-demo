package com.aopano.cars_demo.dto;

import com.aopano.cars_demo.dao.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "car")
@JsonRootName("car")
public class CarDTO implements GenericDTO<Car, CarDTO> {

    @JacksonXmlProperty(localName = "id")
    private Long id;

    @JacksonXmlProperty(localName = "make")
    private String make;

    @JacksonXmlProperty(localName = "model")
    private String model;

    @JacksonXmlProperty(localName = "length")
    private String length;

    @JacksonXmlProperty(localName = "weight")
    private String weight;

    @JacksonXmlProperty(localName = "velocity")
    private String velocity;

    @JacksonXmlProperty(localName = "color")
    private String color;

    @JsonIgnore
    @Override
    public CarDTO map(Car entity) {

        CarDTO carDTO = new CarDTO();

        carDTO.setId(entity.getId());
        carDTO.setMake(entity.getMake());
        carDTO.setModel(entity.getModel());
        carDTO.setLength(entity.getLength());
        carDTO.setWeight(entity.getWeight());
        carDTO.setVelocity(entity.getVelocity());
        carDTO.setColor(entity.getColor());

        return carDTO;
    }

    @Override
    public Car extract() {

        Car car = new Car();

        car.setId(this.getId());
        car.setMake(this.getMake());
        car.setModel(this.getModel());
        car.setLength(this.getLength());
        car.setWeight(this.getWeight());
        car.setVelocity(this.getVelocity());
        car.setColor(this.getColor());

        return car;
    }
}
