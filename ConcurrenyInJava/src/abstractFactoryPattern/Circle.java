package abstractFactoryPattern;
/*Class is not made public so that it can not be accessed outside the package directly, 
 * but only through factory class
 */
class Circle implements Shape{ 
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle");
	}

}
