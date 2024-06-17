package com.aopano.cars_demo;

import com.aopano.cars_demo.dto.CarDTO;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarsDemoAPITest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void defaultModeShouldReturnAll() throws Exception {

        assert this.restTemplate.getForObject("http://localhost:" + port + "/cars/list-all", List.class).size() == 4;
    }

    @Test
    void filteredModeShouldReturnValidValues() throws Exception {

        CarDTO filter = new CarDTO();

        filter.setColor("Silver");

        assert this.restTemplate.postForObject("http://localhost:" + port + "/cars/search", filter, List.class).size() == 2;
    }
}
