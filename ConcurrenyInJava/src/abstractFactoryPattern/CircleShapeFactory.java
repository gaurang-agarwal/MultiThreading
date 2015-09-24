package abstractFactoryPattern;

public class CircleShapeFactory extends AbstractShapeFactory {

	@Override
	public Shape getInstance() {
		// TODO Auto-generated method stub
		return new Circle();
	}

}
