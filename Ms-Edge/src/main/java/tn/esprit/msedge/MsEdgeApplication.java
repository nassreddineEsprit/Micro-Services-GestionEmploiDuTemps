package tn.esprit.msedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEdgeApplication.class, args);
    }

}
