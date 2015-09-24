package abstractFactoryPattern;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape rectangle = FactoryProducer.getFactory("rectangle").getInstance();
		Shape circle = FactoryProducer.getFactory("circle").getInstance();
		rectangle.draw();
		circle.draw();
		

	}

}
