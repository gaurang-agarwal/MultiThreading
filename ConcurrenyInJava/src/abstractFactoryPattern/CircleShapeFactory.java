package abstractFactoryPattern;
/*Class is not made public so that it can not be accessed outside the package directly, 
 * but only through factory class also so that no one can override getShape method
 */
class CircleShapeFactory extends AbstractShapeFactory {

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub
		return new Circle();
	}

}
