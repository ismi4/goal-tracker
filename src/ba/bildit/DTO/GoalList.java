package ba.bildit.DTO;

import java.util.ArrayList;

public class GoalList {

	private Integer id;
	private ArrayList<Goal> listOfGoals;
	
	
	public GoalList() {
		
	}
	
	public GoalList(Integer id, ArrayList<Goal> listOfGoals) {
		this.id = id;
		this.listOfGoals = listOfGoals;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Goal> getListOfGoals() {
		return listOfGoals;
	}

	public void setListOfGoals(ArrayList<Goal> listOfGoals) {
		this.listOfGoals = listOfGoals;
	}
	
	
}
