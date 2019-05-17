package ba.bildit.UI;

import ba.bildit.DTO.User;

public class MainMenu {

	private User currentUser;
	
	public MainMenu(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void mainMenu() {
		
		System.out.println("----- GOAL TRACKER: " + currentUser.getUsername() + " -----");
		System.out.println("1. List all goals");
		System.out.println("2. List finished goals");
		System.out.println("3. List pending goals");
		System.out.println("4. Delete goal");
		System.out.println("5. Set goal as finished");
		System.out.println("6. Set goal as pending");
		System.out.println("7. Log out");
		
		
	}
	
}
