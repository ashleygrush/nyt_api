package NYT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Brings dependencies in to run other applications
@SpringBootApplication
public class Application {

    // starts application to run - jar/war files
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    // Bean to start RESTful API, enables auto configuration
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}

// localhost:8080/nyc/search?keyword=Obama

// localhost:8080/nyt/wordcount?keyword=soccer&searchWords=cup,portugal

//  http://localhost:8080/nyt/wordcount?keyword=soccer

// http://localhost:8080/nyt/wordcount?keyword=Obama&terms=Barack,Michelle,America