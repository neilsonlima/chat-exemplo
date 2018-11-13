package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author neilsonlima@gmail.com
 *
 */

@Entity
@Table(name="users")
public class UserModel {
	private int id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String cpf;
	
	/**
	 * @return the id
	 */
	@Id
	//@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param id
	 * @param email
	 * @param cpf
	 */
	public UserModel(int id, String email, String cpf) {
		super();
		this.id = id;
		this.email = email;
		this.cpf = cpf;
	}
	public UserModel() {
	}

}
