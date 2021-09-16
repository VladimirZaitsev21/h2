package dev.danvega.h2demo;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class H2DemoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(H2DemoApplication.class, args);
		Console.main(args);
	}

}
