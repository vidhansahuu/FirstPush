package BlogApp_Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient// THIS IS THE CLIENT NOW IT WILL INTERACT WITH EUREKA SERVER
public class PostApplication {


	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}
}

