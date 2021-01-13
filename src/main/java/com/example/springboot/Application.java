package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.warn("############## test with e.g. http://localhost:8080/cars/ (using HttpMethod = POST)");

        /*
        Order of logged statements when using a version greater than Spring Boot 2.4.0 / Spring 5.3.1
        ActivityLoggerInterceptor          : ############## ACTUAL preHandle
        CarController                      : ############## ACTUAL controller method
        ActivityLoggerInterceptor          : ############## ACTUAL afterCompletion

        ---------------------------------------------------------------------------

        Order of logged statements when using a version greater than Spring Boot 2.4.0 / Spring 5.3.1
        ActivityLoggerInterceptor          : ############## ACTUAL preHandle
        ActivityLoggerInterceptor          : ############## DUPLICATED preHandle
        CarController                      : ############## ACTUAL controller method
        ActivityLoggerInterceptor          : ############## ACTUAL afterCompletion
        ActivityLoggerInterceptor          : ############## DUPLICATED afterCompletion
         */
        SpringApplication.run(Application.class, args);
    }
}
