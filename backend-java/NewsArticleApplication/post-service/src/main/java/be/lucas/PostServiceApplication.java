package be.lucas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class PostServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PostServiceApplication.class, args);
    }
}
