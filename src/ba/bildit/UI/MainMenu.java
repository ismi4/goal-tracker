package ba.bildit.UI;

import ba.bildit.DTO.User;
import ba.bildit.main.Main;

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
		System.out.println("7. Edit goal");
		System.out.println("8. Log out");
		
		
		int menu = 0;

		while ((menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7 && menu != 8))
			menu = Main.intInput();

		if (menu == 1)
			listAllGoals();
		else if (menu == 2)
			listFinishedGoals();
		else if (menu == 3)
			listPendingGoals();
		else if (menu == 4)
			deleteGoal();
		else if (menu == 5)
			setGoalAsFinished();
		else if (menu == 6)
			setGoalAsPending();
		else if (menu == 7)
			editGoal();
		else if (menu == 8)
			logOut();
		
	}
	
	public void listAllGoals() {
		
	}
	
	public void listFinishedGoals() {
		
	}
	
	public void listPendingGoals() {
		
	}
	
	public void deleteGoal() {
		
	}
	
	public void setGoalAsFinished() {
		
	}
	
	public void setGoalAsPending() {
		
	}
	
	public void editGoal() {
		
	}
	
	public void logOut() {
		System.exit(0);
	}
		
	}
	

