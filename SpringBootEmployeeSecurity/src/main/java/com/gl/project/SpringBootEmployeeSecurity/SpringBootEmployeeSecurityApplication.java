package com.gl.project.SpringBootEmployeeSecurity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gl.project.SpringBootEmployeeSecurity.AppUser.AppUser;
import com.gl.project.SpringBootEmployeeSecurity.AppUser.AppUserService;
		
@SpringBootApplication
public class SpringBootEmployeeSecurityApplication implements CommandLineRunner {
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeSecurityApplication.class, args);
	}	
	@Autowired
	AppUserService appService;
		
	@Override
	public void run(String... args) throws Exception {
		Set<String> authAdmin=new HashSet<>();
		authAdmin.add("Admin");
		
		Set<String> authUser=new HashSet<>();
		authUser.add("User");
		
		PasswordEncoder en=new BCryptPasswordEncoder();
		
		AppUser appAdmin=new AppUser(1, "admin", "admin", en.encode("1234"),authAdmin);
		appService.add(appAdmin);
		 
		
		AppUser appUser=new AppUser(2, "user", "user", en.encode("12345"), authUser);
		appService.add(appUser);	
			
	}	
}		