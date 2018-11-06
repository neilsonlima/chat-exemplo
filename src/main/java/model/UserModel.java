package model;

public class UserModel {
	private int id;
	private String login;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserModel(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public UserModel() {}
}
