package com.amsidh.main;

import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MyMongoOperations {
	private static MongoOperations mongoOperation;

	public static void main(String[] string) {
		Set<String> colls = getInstance().getCollectionNames();
		for (String s : colls) {
			System.out.println(s);
		}
	}

	public static MongoOperations getInstance() {
		if (mongoOperation == null) {
			BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
			mongoOperation = (MongoOperations) factory.getBean("mongoTemplate");
		}
		return mongoOperation;
	}
}