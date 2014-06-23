package beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserListBean {

	private ArrayList<UserBean> registeredUsers;


	public UserListBean()
	{
		registeredUsers = new ArrayList<UserBean>();
		
		// dummy data
		registeredUsers.add(new UserBean("SuperInformatiker1337","Hax@gmail.com","HaxxOr42","HaxxOr42"));
		registeredUsers.add(new UserBean("Hansi","Hansi@gmx.de","123456789","123456789"));
		registeredUsers.add(new UserBean("GoogleBot","111@gmail.com","BotsAreAwesome","BotsAreAwesome"));
		registeredUsers.add(new UserBean("WissensNerd314","pi@gmail.com","SuperSecret","SuperSecret"));
		
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(1); tmpList.add(5); tmpList.add(6); tmpList.add(7); tmpList.add(9);
		registeredUsers.add(new UserBean(	"test","test@gmail.com","test","test",
											"resources/images/userPics/Profilepic.jpg",
											3.0f,4.0f,5.0f,3.5f,7,
											"Dies ist eine Testbeschreibung, in der der Benutzer sich selbst vorstellt und eine kurze Übersicht über seine Person gibt.",
											tmpList));
		
	}

	public ArrayList<UserBean> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(ArrayList<UserBean> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}	
	
}