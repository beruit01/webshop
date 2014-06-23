package beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

//	@javax.persistence.Id
//    @javax.persistence.GeneratedValue(strategy=GenerationType.AUTO)//, generator="my_runway_seq_gen")
//	@SequenceGenerator(name="my_runway_seq_gen", sequenceName="MY_RUNWAY_SEQ")
	private int id;
	
	private String userName;
	private String email;
	private String password;
	private String passwordConfirm;
	
	public UserBean() {
		
	}
	
	public UserBean(String userName, String email, String password, String passwordConfirm) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
