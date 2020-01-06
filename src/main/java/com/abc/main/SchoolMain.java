package com.abc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.entities.SchoolEntity;
import com.abc.repositories.SchoolRepository;

public class SchoolMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		SchoolRepository scr = (SchoolRepository) ctx.getBean("schoolRepository");

		String name = "Amity";
		String address = "2276 penbury";

		SchoolEntity se = scr.getSchoolByName(name);
		if (se == null) {
			System.out.println("name :" + "doesnt exist");

		} else {
			System.out.println("here you go ");
		}

	}

}
