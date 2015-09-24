package abstractFactoryPattern;

public class FactoryProducer {

	public static AbstractShapeFactory getFactory(String type){
		if("rectangle".equals(type))
		return new RectangleShapeFactory();
		else if("circle".equals(type))
			return new CircleShapeFactory();
		return null;
		
	}
	
}
