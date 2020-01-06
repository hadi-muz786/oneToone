package com.abc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.entities.SchoolEntity;
import com.abc.entities.StudentEntity;
import com.abc.repositories.SchoolRepository;
import com.abc.repositories.StudentRepository;

public class InsertMainApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		StudentRepository str = (StudentRepository) ctx.getBean("studentRepository");
		
		SchoolEntity sch= new SchoolEntity();
		sch.setAddress("3025 prop ave");
		sch.setEmail("hadi@gmail.com");
		sch.setName("Hadi");
		
		StudentEntity st = new StudentEntity();
		st.setName("Ahmad");
		st.setRollNum("9");
		st.setPhoNum("1234");
		
		
	
		sch.setStudent(st);
		str.save(sch);

	

	}

}
