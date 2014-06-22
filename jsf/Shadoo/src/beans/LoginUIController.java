package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import beans.Login;

@Named
@RequestScoped
public class LoginUIController implements Serializable {

	@Inject
	private Login loginModel;
	
	@Inject
	private UserBean userBean;
	
	@Inject
	private UserListBean userListBean;
	
	private String loginError = "";
	
	
	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public String checkPw() {
		
		ArrayList<UserBean> userList = userListBean.getRegisteredUsers();
		for(UserBean curUser : userList) {
			if(!loginModel.getLogin().isEmpty()) {
				if (loginModel.getLogin().equals(curUser.getUserName())
					&& loginModel.getPassword().equals(curUser.getPassword())) {
					loginError = "";
					return "index";
				}
			}
		}
		loginError = "Die Kombination aus Benutzername und Passwort gibt es nicht!";
		return "";
		
	}
	
	public String registerUser() {
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		String validationFailed = context.validationFailed();
		loginModel.setLogin(userBean.getUserName());
		loginModel.setPassword(userBean.getPassword());
		ArrayList<UserBean> tmpList = userListBean.getRegisteredUsers();
		tmpList.add(userBean);
		userListBean.setRegisteredUsers(tmpList);
		System.out.println("You have registered successfully!");
		return "index";
		
	}

//	public void validateLogin(FacesContext context, UIComponent component,
//			Object checkValue) throws ValidatorException {
//		boolean validate = false;
//		String check = checkPw();
//		System.out.println(check);
//		if (!(check.isEmpty())) {validate = true;}
//		if (!validate) {
//			FacesMessage errMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//					"Die Kombination aus Benutzername und Passwort gibt es nicht!", "Die Kombination aus Benutzername und Passwort gibt es nicht!");
//			throw new ValidatorException(errMsg);
//		}
//	}
}
