package System;


/**
 * @author Administrator
 * @version 1.0
 * @created 07-11��-2019 21:25:55
 */
public class CreatorA extends Creactor {

	public CreatorA(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Product FactoryMethod(){
		return null;
	}

}