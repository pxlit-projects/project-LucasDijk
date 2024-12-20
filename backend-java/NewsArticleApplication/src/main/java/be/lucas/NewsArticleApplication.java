package be.lucas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
EnableFeignClients
public class NewsArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsArticleApplication.class, args);
    }

}
