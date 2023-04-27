package com.VendingMachine.VendingMachine01;

//import com.VendingMachine.VendingMachine01.logger.LoggingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//update only not working as of crud operations  and added jsp
@SpringBootApplication
public class VendingMachine01Application  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(VendingMachine01Application.class);

	}
	public static void main(String[] args) {
		SpringApplication.run(VendingMachine01Application.class, args);
		//new LoggingController().index();
	}
}
