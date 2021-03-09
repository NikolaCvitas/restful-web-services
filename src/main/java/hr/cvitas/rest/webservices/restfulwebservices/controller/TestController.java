package hr.cvitas.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    @GetMapping( path="/test")
    public String test(){

        return "It works";
    }


    @GetMapping( path="/test-bean")
    public TestBean bean(){

        return new TestBean( "Test Bean" );
    }

    @GetMapping( path="/test/var/{name}")
    public TestBean variable(@PathVariable String name){

        System.out.println("test/var ____________");

      //  throw new RuntimeException("Something went wrong");
        return new TestBean(String.format("Hello, %s", name));
    }
}
