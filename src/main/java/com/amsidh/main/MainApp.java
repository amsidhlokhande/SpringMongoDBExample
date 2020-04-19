package com.amsidh.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.amsidh.domain.Person;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:springConfiguration5.xml");
		context.registerShutdownHook();
		MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
		List<Person> persons = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {
			persons.add(new Person(i, "Amsidh" + i, "Pune" + i));
		}
		mongoTemplate.insertAll(persons);

		List<Person> ps = mongoTemplate.findAll(Person.class);

		for (Person p : ps) {
			System.out.println(p.toString());
		}
		
		context.close();
	}
	
	

}
