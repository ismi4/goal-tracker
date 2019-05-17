package ba.bildit.main;

import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int intInput() {

		int intInput = 0;

		while (true)
			try {
				intInput = input.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Your input is not correct!");
				input.nextLine();
				continue;
			}

		return intInput;

	}

}
