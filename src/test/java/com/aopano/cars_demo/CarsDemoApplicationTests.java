package com.aopano.cars_demo;

import com.aopano.cars_demo.dto.CarDTO;
import com.aopano.cars_demo.dto.wrapper.CarsXml;
import com.aopano.cars_demo.service.api.CarDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CarsDemoApplicationTests {

	@Autowired
	private CarDataService carDataService;

	@Test
	void contextLoads() {

		assert carDataService != null;
	}

	@Test
	void dataReadTest() {

		List<CarDTO> cars = carDataService.findCars(null);

		assert cars.size() == 4;
	}

	@Test
	void findByMakeAndModelTest() {

		CarDTO toyotaCamry = new CarDTO();

		toyotaCamry.setMake("Toyota");
		toyotaCamry.setModel("Camry");

		List<CarDTO> allCamry = carDataService.findCars(toyotaCamry);

		assert allCamry.size() == 2;
	}

	@Test
	void allCamryAndSilverTest() {

		CarDTO toyotaCamry = new CarDTO();

		toyotaCamry.setMake("Toyota");
		toyotaCamry.setModel("Camry");
		toyotaCamry.setColor("Silver");

		List<CarDTO> allCamry = carDataService.findCars(toyotaCamry);

		assert allCamry.size() == 1;
	}

	@Test
	void allSilverTest() {

		CarDTO silverCar = new CarDTO();

		silverCar.setColor("Silver");

		List<CarDTO> allSilver = carDataService.findCars(silverCar);

		assert allSilver.size() == 2;
	}

	@Test
	public void testXMLConversion() throws JsonProcessingException {

		List<CarDTO> cars = carDataService.findCars(null);

		CarsXml carsXml = new CarsXml();

		carsXml.setCarList(cars);

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

		String xml = xmlMapper.writeValueAsString(carsXml);

		System.out.println(xml);

		assert xml != null;
	}
}
