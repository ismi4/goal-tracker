package ba.bildit.DTO;

public class User {

	private Integer id;
	private String username;
	private String name;
	private String surname;
	private GoalList listOfGoals;
	private String password;
	
	private User() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public GoalList getListOfGoals() {
		return listOfGoals;
	}
	
	public void setListOfGoals(GoalList listOfGoals) {
		this.listOfGoals = listOfGoals;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
