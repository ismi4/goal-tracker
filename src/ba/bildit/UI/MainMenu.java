package ba.bildit.UI;

import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DAO.GoalDAOImplementation;
import ba.bildit.DTO.Goal;
import ba.bildit.DTO.User;
import ba.bildit.main.Main;

public class MainMenu {

	private User currentUser;
	private ArrayList<Goal> currentGoalList = currentUser.getListOfGoals().getListOfGoals();
	private final boolean PENDING = false;
	private final boolean FINISHED = true;
	
	public MainMenu(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void mainMenu() {
		
		System.out.println("----- GOAL TRACKER: " + currentUser.getUsername() + " -----");
		System.out.println("1. List all goals");
		System.out.println("2. List finished goals");
		System.out.println("3. List pending goals");
		System.out.println("4. Add new goal");
		System.out.println("5. Delete goal");
		System.out.println("6. Set goal as finished");
		System.out.println("7. Set goal as pending");
		System.out.println("8. Edit goal");
		System.out.println("9. Log out");
		
		
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
			addNewGoal();
		else if (menu == 5)
			deleteGoal();
		else if (menu == 6)
			setGoalAsFinished();
		else if (menu == 7)
			setGoalAsPending();
		else if (menu == 8)
			editGoal();
		else if (menu == 9)
			logOut();
		
		mainMenu();
		
	}
	
	public void listAllGoals() {
		
		for (Goal goal : currentGoalList)
			System.out.println(goal.toString());
			
		
	}
	
	public void listFinishedGoals() {
		
		for (Goal goal : currentGoalList)
			if(goal.isCompleted())
			System.out.println(goal.toString());
		
	}
	
	public void listPendingGoals() {
		
		for (Goal goal : currentGoalList)
			if(!goal.isCompleted())
			System.out.println(goal.toString());
		
	}
	
	public void addNewGoal() {
		
		
		System.out.println("Enter name of the goal:");
		String goalName = Main.input.next();
		
		if (!doesGoalExist(goalName)) {
			
			System.out.println("Enter text of the goal: ");
			String goalText = Main.input.next();
			
			try {
				(new GoalDAOImplementation()).setGoal(currentUser.getId(), goalName, goalText, PENDING);
				currentGoalList.add(new Goal(currentUser.getId(),goalName,goalText, PENDING));
		
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to add new goal!");
			}
			
			
		} else {
			System.out.println("That goal with that name already exists!");
		}
		
	}
	
	public void deleteGoal()  {
		
		System.out.println("Enter name of the goal you want to delete: ");
		String goalName = Main.input.next();
		
		if (doesGoalExist(goalName)) {
			try {
				(new GoalDAOImplementation()).deleteGoal(currentUser.getId(), goalName);
				for (int i = 0; i < currentGoalList.size(); i++)
					if (currentGoalList.get(i).getGoalName().equals(goalName))
						currentGoalList.remove(i);
		
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to delete goal!");
			}
		} else {
			System.out.println("That goal doesn't exist!");
		}
		
		
	}
	
	public void setGoalAsFinished() {
	
		
		System.out.println("Enter name of the goal you want to set as finished: ");
		String goalName = Main.input.next();
		
		if (doesGoalExist(goalName)) {
			
			try {
				(new GoalDAOImplementation()).editGoalCompletedField(currentUser.getId(), goalName, FINISHED);;
				for (int i = 0; i < currentGoalList.size(); i++)
					if (currentGoalList.get(i).getGoalName().equals(goalName))
						currentGoalList.get(i).setCompleted(FINISHED);
		
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to set goal as finished!");
			}
			
		} else {
			System.out.println("That goal doesn't exist!");
		}
		
	}
	
	public void setGoalAsPending() {
		
		System.out.println("Enter name of the goal you want to set as pending: ");
		String goalName = Main.input.next();
		
		if (doesGoalExist(goalName)) {
			
			try {
				(new GoalDAOImplementation()).editGoalCompletedField(currentUser.getId(), goalName, PENDING);;
				for (int i = 0; i < currentGoalList.size(); i++)
					if (currentGoalList.get(i).getGoalName().equals(goalName))
						currentGoalList.get(i).setCompleted(PENDING);
		
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to set goal as pending!");
			}
			
		} else {
			System.out.println("That goal doesn't exist!");
		}
		
	}
	
	public void editGoal() {
		
		System.out.println("Enter name of the goal you want to edit: ");
		String goalName = Main.input.next();
		
		System.out.println("Enter new name: ");
		String newGoalName = Main.input.next();
		
		System.out.println("Enter new goal text: ");
		String newGoalText = Main.input.next();
		
		if (doesGoalExist(goalName)) {
			
			try {
				(new GoalDAOImplementation()).editGoal(currentUser.getId(), goalName, newGoalName, newGoalText);
				for (int i = 0; i < currentGoalList.size(); i++)
					if (currentGoalList.get(i).getGoalName().equals(goalName)) {
						currentGoalList.get(i).setGoalName(newGoalName);
						currentGoalList.get(i).setGoalText(newGoalText);
					}
		
			} catch (SQLException e) {
				System.out.println("There was an issue while trying to edit the goal!");
			}
			
		} else {
			System.out.println("That goal doesn't exist!");
		}
		
		
		
	}
	
	
	public void logOut() {
		InitialMenu.initialMenu();
	}
	
	public boolean doesGoalExist(String goalName) {
		
		for (Goal goal : currentGoalList) 
			if (goal.getGoalName().equals(goalName))
				return true;
		
		return false;
		
	}
	}
	

