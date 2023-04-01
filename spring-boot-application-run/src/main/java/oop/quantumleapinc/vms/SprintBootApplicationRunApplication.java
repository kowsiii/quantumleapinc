package oop.quantumleapinc.vms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import oop.quantumleapinc.vms.service.EmailSenderService;



@ComponentScan
@SpringBootApplication
public class SprintBootApplicationRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootApplicationRunApplication.class, args);
		
	}
	@Autowired
	private EmailSenderService senderService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("glenn-hamm@outlook.com","test","hello");
	}

}

