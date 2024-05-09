package BlogApp_Microservices.Comment.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ResttemplateConfig {// REST TEMPLATES CLASS HELPS US TO INTERACT WITH OTHER PROJECTS
@Bean                     // IF COMMENT HAS REST TEMPLATE FEATURE IT CAN INTERACT WITH POST AND VICEVERSA
public RestTemplate getResttemplate(){
    return new RestTemplate(); //import org.springframework.web.client.RestTemplate; IMPORT RESTTEMPLET FROM WEB CLIENT

}

}
