package abstractFactoryPattern;

public class RectangleShapeFactory extends AbstractShapeFactory {

	@Override
	public Shape getInstance() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

}
