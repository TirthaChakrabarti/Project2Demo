package Main;

import constructionProcess.ConstructionImplementation;

public class Driver {

	public static void main(String[] args) {

		ConstructionImplementation obj = new ConstructionImplementation();

		try {
			obj.collectSupplyDetails();
			obj.showConstructionOrder();
		} catch (RuntimeException e) {
			System.out.println("\nAn exception occured: \n" + e.getMessage());
		}
	}
}
