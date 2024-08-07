package pt.goncalo.reproducers.ijhttp_not_stoping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class IjhttpNotStopingApplication {

    public static void main(String[] args) {
        SpringApplication.run(IjhttpNotStopingApplication.class, args);
    }


    @RestController
    public static class TestController {
        @GetMapping("")
        public String test() {
            return "Hello Hello..";
        }

    }

}
