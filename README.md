This sample project demonstrates what is described in this spring issue: https://github.com/spring-projects/spring-framework/issues/26378
There are two branches in this project. One that works (with old Spring Boot / Spring version) and one that doesn't (with newer versions)


To test, just make a post (e.g via the application called postman) to the URL http://localhost:8080/cars/ (port might be different on your system)

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