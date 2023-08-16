package de.nessinale.VertretungsplanBackend;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class VertretungsplanBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VertretungsplanBackendApplication.class, args);
	}

}
