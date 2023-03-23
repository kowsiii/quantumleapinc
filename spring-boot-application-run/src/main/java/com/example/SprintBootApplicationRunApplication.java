
package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.entity.FormPermissions;



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

}

