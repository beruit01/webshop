package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import beans.Login;

@Named
@SessionScoped
public class LoginUIController implements Serializable {

	@Inject
	private Login loginModel;
	
	@Inject
	private UserBean userBean;
	
	@Inject
	private UserListBean userListBean;
	
	@Inject
	private ListControllerBean listControllerBean;
	
	private String loginError = "";
	private String registerError = "";
	private String navbarLoginCaption = "Login";
	private String pageAfterLogReg = "";
	private UserBean curUser;
	private int curUserId;
	

	public String checkPw() {
		
		ArrayList<UserBean> userList = userListBean.getRegisteredUsers();
		for(UserBean curUser : userList) {
			if(!loginModel.getLogin().isEmpty()) {
				if (loginModel.getLogin().equals(curUser.getUserName())
					&& loginModel.getPassword().equals(curUser.getPassword())) {
					loginModel.setLoggedIn(true);
					loginError = "";
					if(loginModel.getLogin().length() <= 15) {
						navbarLoginCaption = loginModel.getLogin();
					} else {
						navbarLoginCaption = loginModel.getLogin().substring(0, 12) + "...";
					}
					return pageAfterLogReg;
				}
			}
		}
		loginModel.setLoggedIn(false);
		loginError = "Die Kombination aus Benutzername und Passwort gibt es nicht!";
		return "";
		
	}
	
	public String registerUser() {
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		String validationFailed = context.validationFailed();
		
//		ArrayList<UserBean> userList = userListBean.getRegisteredUsers();
//		for(UserBean curUser : userList) {
//			if(curUser.getUserName().equals(userBean.getUserName())) {
//				registerError = "Der angegebene Benutzername ist bereits vergeben";
//				return "";
//			}
//		}
		
		if(!(registerError.equals(""))) {
			return "";
		}
		
		loginModel.setLogin(userBean.getUserName());
		loginModel.setPassword(userBean.getPassword());
		ArrayList<UserBean> tmpList = userListBean.getRegisteredUsers();
		userBean.setImageUrl("resources/images/userPics/defaultuser.jpg");
		tmpList.add(userBean);
		userListBean.setRegisteredUsers(tmpList);
		loginModel.setLoggedIn(true);
		registerError = "";
		if(loginModel.getLogin().length() <= 15) {
			navbarLoginCaption = loginModel.getLogin();
		} else {
			navbarLoginCaption = loginModel.getLogin().substring(0, 12) + "...";
		}
		
		return pageAfterLogReg;
//		return "welcome";
		
	}
	
	public void validateUserName(AjaxBehaviorEvent ev) {
		
		if(userBean != null) {
			ArrayList<UserBean> userList = userListBean.getRegisteredUsers();
			for(UserBean curUser : userList) {
				if(curUser.getUserName().equals(userBean.getUserName())) {
					registerError = "Der angegebene Benutzername ist bereits vergeben!";
					return;
				}
			}
		}
		registerError = "";
		
	}
	
	public void passwordValidator(FacesContext context, UIComponent toValidate, Object value) {

//		FacesContext ctx = FacesContext.getCurrentInstance();
//		HttpServletRequest request =
//		      (HttpServletRequest)ctx.getExternalContext().getRequest();
//		System.out.println("hier: " + ctx);
//		System.out.println("hier: " + request);
//		System.out.println("hier: " + request.getParameter("passwordForm:reg_pw"));
//		
//	    UIInput passwordField = (UIInput) context.getViewRoot().findComponent("passwordForm:reg_pw");
//	    System.out.println("test: " + context.getViewRoot().findComponent("passwordForm:reg_pw"));
//	    if (passwordField == null)
//	        throw new IllegalArgumentException(String.format("Unable to find component."));
//	    String password = (String) passwordField.getValue();
		String password = userBean.getPassword();
	    String confirmPassword = (String) value;
	    if (!confirmPassword.equals(password)) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwörter stimmen nicht überein!", "Passwörter stimmen nicht überein!");
	        throw new ValidatorException(message);
	    }
	    
	}
	
	public String doLogout() {
		
		if(loginModel.isLoggedIn()) {
			loginModel.setLoggedIn(false);
			loginModel.setLogin("");
			loginModel.setPassword("");
			setNavbarLoginCaption("Login");
			return "index";
		}
		return "";
		
	}
	
	public String navLogin() {
		
		if(loginModel.isLoggedIn()) {
			curUser = userListBean.getUserByUserName(loginModel.getLogin());
			System.out.println("hhhhhhhhhhhhhhhh " + curUser.getImageUrl());
			return "account";
		}
//		userBean = null;
		loginModel.setLoggedIn(false);
		loginModel.setLogin("");
		loginModel.setPassword("");
		directLinkingAfterLogReg("login");
		return "login";
		
	}
	
	public String getLoggedInClass() {
		if(loginModel.isLoggedIn()) {
			return "loggedIn";
		} else {
			return "loggedOut";
		}
		
	}
	
	public String directLinkingAfterLogReg (String curPage) {
		if(loginModel.isLoggedIn()) {
			if(curPage.equals("login")) return "login";
			else if(curPage.equals("productTake")) return "heartbox";
			else if(curPage.equals("productRate")) return "rating";
			else if(curPage.equals("heartbox")) return "heartbox";
			else if(curPage.equals("share")) return "share";
			else return "";
		} else {
			if(curPage.equals("login")) pageAfterLogReg = "welcome";
			else if(curPage.equals("productTake")) pageAfterLogReg = "heartbox";
			else if(curPage.equals("productRate")) pageAfterLogReg = "rating";
			else if(curPage.equals("heartbox")) pageAfterLogReg = "heartbox";
			else if(curPage.equals("share")) pageAfterLogReg = "share";
			else pageAfterLogReg = "index";
			return "login";
		}
	}
	
	public String setCurUser() {
		
		int id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id") );
		System.out.println("ID: " + id);
		ProductBean curProd = listControllerBean.getProductsById( id );
		
		userBean = curProd.getAuthor();
		curUser = curProd.getAuthor();
		System.out.println("curUser??????????? " + curUser);
		System.out.println("userBean.getUserName(): " + userBean.getUserName());
		return "account";
	}

	public String getNavbarLoginCaption() {
		return navbarLoginCaption;
	}

	public void setNavbarLoginCaption(String navbarLoginCaption) {
		this.navbarLoginCaption = navbarLoginCaption;
	}
	
	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}
	
	public String getRegisterError() {
		return registerError;
	}

	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}

	public UserBean getCurUser() {
		return curUser;
	}

	public void setCurUser(UserBean curUser) {
		this.curUser = curUser;
	}

	public int getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(int curUserId) {
		this.curUserId = curUserId;
	}

	public String getPageAfterLogReg() {
		return pageAfterLogReg;
	}

	public void setPageAfterLogReg(String pageAfterLogReg) {
		this.pageAfterLogReg = pageAfterLogReg;
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
