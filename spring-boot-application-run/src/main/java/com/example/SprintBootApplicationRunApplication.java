
package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import com.example.entity.FormPermissions;
import com.example.service.EmailSenderService;


@ComponentScan
@SpringBootApplication
public class SprintBootApplicationRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootApplicationRunApplication.class, args);

		FormPermissions one = new FormPermissions(false,true,"modifierGuy");
		FormPermissions two = new FormPermissions(true,true,"modifierGuy");

	

		//System.out.println(one.getModifiedBy());
		//private int permissionId;
		//private boolean permissionWrite;
		//private boolean permissionRead;
		//private String modifiedBy;
	}
	@Autowired
	private EmailSenderService senderService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("glenn-hamm@outlook.com","test","hello");
	}

}

