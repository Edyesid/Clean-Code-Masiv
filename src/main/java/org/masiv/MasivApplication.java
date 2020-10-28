package org.masiv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
@SpringBootApplication
@EnableRedisRepositories
public class MasivApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasivApplication.class, args);
    }
}