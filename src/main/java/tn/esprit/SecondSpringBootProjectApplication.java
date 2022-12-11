package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SecondSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondSpringBootProjectApplication.class, args);
	
	}

}
