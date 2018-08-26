package com.machintosh1983.var.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Machintosh1983
 *
 */
@SpringBootApplication
public class ApplicationLaunch implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationLaunch.class,args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
