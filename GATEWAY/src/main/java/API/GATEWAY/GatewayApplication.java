package API.GATEWAY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {// THIS PROJECT CAN ROUTE INCOMING REQUESTS TO THE REQUIRED MICROSERVICES WITH ONE URL AND ONE PORT
                                  // ALL OUR SPRING SECURITY WE CAN IMPLEMENT ON A GATEWAY..
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
// NOW WHEN WE CALL THIS API GATEWAY WHICH IS RUNNING ON PORT 8083 THIS GATEWAY HAS 2 CHANNELS POST-SERVICE AND COMMENT-SERVICE
// AND FROM THIS GATE WAY WE CAN CALL BOTH POST-SERVICE AND COMMENT-SERVICE WE CAN CALL THIS BY USING SINGLE URL PORT 8083..