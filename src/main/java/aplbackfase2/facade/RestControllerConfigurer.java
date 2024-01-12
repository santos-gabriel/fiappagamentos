package aplbackfase2.facade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestControllerConfigurer {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
