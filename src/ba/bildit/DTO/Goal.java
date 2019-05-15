package ba.bildit.DTO;

public class Goal {

	private Integer id;
	private String goalName;
	private String goalText;
	private Boolean completed = false;

	public Goal() {
		
	}
	
	public Goal(Integer id, String goalName, String goalText) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
