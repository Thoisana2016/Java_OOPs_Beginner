package dev.thoisana.FirstProject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstApp {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping("/hello/{name}")
    public String sayHelloName(@PathVariable("name") String personName){
        return "hello "+personName;
    }

    @RequestMapping("/hello/{fname}/{lname}")
    public String sayHelloFNameLName(@PathVariable("fname") String fName, @PathVariable("lname") String lName){
        return "hello "+fName+" "+lName;
    }
}
