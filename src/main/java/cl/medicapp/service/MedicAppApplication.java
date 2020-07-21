package cl.medicapp.service;

import cl.medicapp.service.configuration.SecurityPropertiesLoaderFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@PropertySource(value = "classpath:/security.yml", factory = SecurityPropertiesLoaderFactory.class)
@Slf4j
public class MedicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicAppApplication.class, args);
    }

}
