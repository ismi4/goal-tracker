package ba.bildit.DTO;

public class UserBuilder {

	private Integer id;
	private String username;
	private String name;
	private String surname;
	private GoalList listOfGoals;
	private String password;
	
	public UserBuilder(Integer id) {
		this.id = id;
	}
	
	public UserBuilder withUsername(String username) {
		this.username = username;
		return this;
	}
	
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder withSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public UserBuilder withListOfGoals(GoalList listOfGoals) {
		this.listOfGoals = listOfGoals;
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	 public User build(){
         User user = new User();  
         user.setId(this.id);
         user.setUsername(this.username);
         user.setName(this.name);
         user.setSurname(this.surname);
         user.setListOfGoals(this.listOfGoals);
         user.setPassword(password);
         return user;
     }
	
}
