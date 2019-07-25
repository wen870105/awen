package com.wen.mongo;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.wen.mongo.dao.User;

@Service
public class MongoService {
	private static final Logger logger = LoggerFactory.getLogger(MongoService.class);
	@Autowired
	private MongoOperations mongo;
	
	public void test() {
		User u = new User();
		u.setUsername("n1");
		u.setPassword("pwd1");
		mongo.insert(u);
		mongo.save(u);
		Set<String> ss = mongo.getCollectionNames();
		for(String s : ss){
			DBCollection coll = mongo.getCollection(s);
			DBCursor cur = coll.find();
			for(DBObject obj : cur){
				System.out.println(obj);
			}
			
			System.out.println(coll);
			System.out.println(s);
			
			
		}
		
		logger.info("hahahahah");	
		System.out.println("emnd");
		
		
		
	}
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		MongoService mongo = ctx.getBean(MongoService.class);
		mongo.test();
	}
}
