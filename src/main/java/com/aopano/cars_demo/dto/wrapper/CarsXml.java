package com.aopano.cars_demo.dto.wrapper;

import com.aopano.cars_demo.dao.model.Car;
import com.aopano.cars_demo.dto.CarDTO;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "cars")
public class CarsXml {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "car")
    List<CarDTO> carList;
}
