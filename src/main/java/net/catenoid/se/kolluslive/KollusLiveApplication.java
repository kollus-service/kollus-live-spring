package net.catenoid.se.kolluslive;

import net.catenoid.se.kolluslive.api.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

// Spring boot Security 자동 설정 제외
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})

public class KollusLiveApplication {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(KollusLiveApplication.class, args);
    }


}
