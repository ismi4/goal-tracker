package ba.bildit.DTO;

public class Goal {

	private String goalName;
	private String goalText;
	private boolean completed = false;
	
	public Goal() {
		
	}
	
	public Goal(String goalName, String goalText) {
		this.goalName = goalName;
		this.goalText = goalText;
	}
	
	
	public String getGoalName() {
		return goalName;
	}
	
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalText() {
		return goalText;
	}
	public void setGoalText(String goalText) {
		this.goalText = goalText;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
	
}
