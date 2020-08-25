package com.FileAClaim.FileAClaimAPI;

import com.FileAClaim.FileAClaimAPI.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({FileStorageProperties.class})
public class FileAClaimApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileAClaimApiApplication.class, args);
    }

}
