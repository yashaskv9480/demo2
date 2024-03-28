package com.example.LabCycle02;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LabCycle02Application {

	public static void main(String[] args) {
		SpringApplication.run(LabCycle02Application.class, args);
		Scanner sc = new Scanner(System.in);
		ApplicationContext ac = new ClassPathXmlApplicationContext("coldept.xml");
		Department dt = (Department) ac.getBean("department");

		while (true) {
			System.out.println(
					"1.Insert the department details\n" + "2.Display department with college details\n" + "3.exit");
			System.out.println("enter the choice");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.println("Enter the department name");
				dt.setName(sc.next());
				System.out.println("Enter the department number");
				dt.setId(sc.nextInt());
				System.out.println("Enter the department description");
				dt.setDescription(sc.next());
				System.out.println("Thanks for input");
				break;
			case 2:
				System.out.println("Department details:");
				System.out.println("Name:" + dt.getName() + " " + " ID:" + dt.getId() + "Deapartment Description"
						+ dt.getDescription());
				System.out.println("College Details");
				College c = dt.getCollege();
				System.out.println("College Name: " + c.getName());
				System.out.println("College Address: " + c.getAddress());
				break;
			case 3:
				System.exit(0);
			}
		}
	}

}
