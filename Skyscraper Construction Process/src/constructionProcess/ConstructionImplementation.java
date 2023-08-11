package constructionProcess;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructionImplementation implements constructionInterface {

	Scanner scan = new Scanner(System.in);

	private int floorSizes[];
	private int floorSupply[];
	private static Queue<Integer> dailyProcess = new LinkedList<Integer>();
	private static int pointer;

	@Override
	public void collectSupplyDetails() {

		System.out.print("Enter total number of floors in the building: ");
		int noOfFloors = scan.nextInt();

		if (noOfFloors <= 0) {
			throw new RuntimeException("Invalid entry. Number of floor cannot be zero or negative.");
		}

		floorSizes = new int[noOfFloors];
		floorSupply = new int[noOfFloors];
		System.out.println();

		for (int i = 0; i < noOfFloors; i++) {
			System.out.print("Enter the floor size given on Day " + (i + 1) + ": ");
			int size = scan.nextInt();

			if (size <= 0) {
				throw new RuntimeException("Invalid entry. Size of floor cannot be zero or negative.");
			}

			floorSupply[i] = size;
			floorSizes[i] = size;
		}

		for (int i = 0; i < floorSupply.length - 1; i++) {
			for (int j = i + 1; j < floorSupply.length; j++) {
				if (floorSupply[i] == floorSupply[j]) {
					throw new RuntimeException("Invalid entry. Every floor must have distinct size.");
				}
			}
		}
	}

	@Override
	public void showConstructionOrder() {

		System.out.print("\nDaily records of floor supply: ");
		System.out.println(Arrays.toString(floorSupply));
		System.out.println("\nThe order of construction is as follows: ");
		System.out.println();

		Arrays.sort(floorSizes);
		pointer = floorSizes.length - 1;

		for (int day = 1; day <= floorSizes.length; day++) {
			findConstructionOrder(day);
			System.out.print("Day " + day + ": ");
			while (!dailyProcess.isEmpty()) {
				System.out.print(dailyProcess.remove() + " ");
			}
			System.out.println();
		}
	}

	private void findConstructionOrder(int day) {

		boolean floorFound;
		do {
			floorFound = false;
			for (int i = 1; i <= day; i++) {
				if (floorSupply[i - 1] == floorSizes[pointer]) {
					dailyProcess.add(floorSupply[i - 1]);
					pointer--;
					floorFound = true;
					break;
				}
			}
		} while ((pointer >= 0) && (floorFound == true));
	}
}
