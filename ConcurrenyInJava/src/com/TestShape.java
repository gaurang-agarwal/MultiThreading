package com;

import abstractFactoryPattern.FactoryProducer;
import abstractFactoryPattern.Shape;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape rectangle = FactoryProducer.getFactory("rectangle").getShape();
		Shape circle = FactoryProducer.getFactory("circle").getShape();
		rectangle.draw();
		circle.draw();
		

	}

}
