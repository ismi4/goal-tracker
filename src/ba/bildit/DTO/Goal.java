package ba.bildit.DTO;

public class Goal {

	private Integer id;
	private String goalName;
	private String goalText;
	private Boolean completed = false;

	public Goal() {
		
	}
	
	public Goal(Integer id, String goalName, String goalText, boolean completed) {
		this.goalName = goalName;
		this.goalText = goalText;
		this.completed = completed;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "-----" + goalName + " -----" + "\n" + goalText;
	}
	
	
	
	
}
