package com.example.springboot;

import com.example.springboot.persistence.Car;
import com.example.springboot.persistence.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@RepositoryRestController
@Slf4j
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // we use GetMappings via HATEOAS und all write operations with custom RepositoryRestController
    // test with e.g. http://localhost:8080/cars/ (using HttpMethod = POST)
    @PostMapping("/cars")
    public ResponseEntity<Car> createDummy(HttpServletRequest request) {
        log.warn("############## ACTUAL controller method");
        Car savedCar = carRepository.save(new Car(0L, "dummyValue"));
        return new ResponseEntity<>(savedCar, HttpStatus.OK);
    }
}
