package com.yedam.app.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainExample {
	   public static void main(String[] args) {
		   ApplicationContext ctx
		   = new GenericXmlApplicationContext
		       ("classpath:applicationContext.xml");
           // IoC컨테이너 안에 등록된 Bean은 정상적으로 동작된다고 가정
		   Restaurant res
		       = (Restaurant)ctx.getBean(Restaurant.class);
		   
		   res.run();
	   }
}
