package model;
/**
 * @author neilsonlima@gmail.com
 *
 */
public class UserModel {
	private int id;
	private String email;
	private String cpf;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public UserModel(int id, String email, String cpf) {
		this.id = id;
		this.email = email;
		this.cpf = cpf;
	}
	public UserModel() {}
}
