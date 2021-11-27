package br.com.devhall.DevHall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DevHallApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevHallApplication.class, args);
	}

}
