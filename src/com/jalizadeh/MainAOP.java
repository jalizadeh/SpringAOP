package com.jalizadeh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jalizadeh.service.Shape;

public class MainAOP {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Shape shape = context.getBean("shape", Shape.class);
		
		System.out.println(shape.getCircle().getName());
		context.close();
	}

}
