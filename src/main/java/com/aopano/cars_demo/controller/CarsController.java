package com.aopano.cars_demo.controller;

import com.aopano.cars_demo.dao.model.Car;
import com.aopano.cars_demo.dto.CarDTO;
import com.aopano.cars_demo.dto.wrapper.CarsXml;
import com.aopano.cars_demo.service.api.CarDataService;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class CarsController {

    @Autowired
    private CarDataService carDataService;

    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping("/cars/list-all")
    public @ResponseBody List<CarDTO> list() {

        return carDataService.findCars(null);
    }

    @RequestMapping(value = "/cars/search", method = RequestMethod.POST)
    public @ResponseBody List<CarDTO> list(@RequestBody CarDTO filter) {

        return carDataService.findCars(filter);
    }

    @RequestMapping(value = "/cars/download-xml", method = RequestMethod.POST, produces = { "application/json" })
    public @ResponseBody ResponseEntity downloadXML(HttpServletResponse response, @RequestBody CarDTO filter) throws Exception {

        List<CarDTO> cars = carDataService.findCars(filter);

        CarsXml carsXml = new CarsXml();

        carsXml.setCarList(cars);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        String xml = xmlMapper.writeValueAsString(carsXml);

        String fileName = UUID.randomUUID() + ".xml";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + fileName);
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/xml");

        ResponseEntity respEntity = new ResponseEntity(xml.getBytes(StandardCharsets.UTF_8), responseHeaders, HttpStatus.OK);

        return respEntity;
    }
}
