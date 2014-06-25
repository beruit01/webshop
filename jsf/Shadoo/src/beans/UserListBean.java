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

import sun.net.RegisteredDomain;

@Named
@ApplicationScoped
public class UserListBean {

	private ArrayList<UserBean> registeredUsers;
	private static ArrayList<UserBean> allUsers = new ArrayList<UserBean>();

	public UserListBean()
	{
		registeredUsers = new ArrayList<UserBean>();
		
		// dummy data
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(2); tmpList.add(4); tmpList.add(5);
		registeredUsers.add(new UserBean("Michael Faber","mfarber@gmail.com","123456","123456","resources/images/userPics/michaelfaber.jpg",2.0f,3.0f,4.5f,5f,3,
				"Ich bin schon seit meiner Kindheit an Technik interessiert. Deshalb habe ich schon früh begonnen Websites zu entwerfen und hatte Spaß daran neue Technologien zu erlernen."+
				"In meinem Studium konnte ich grundlegende Informatikkenntnisse erlenen und kann mein Wissen im Bereich Webdesign vertiefen.", tmpList ));
		tmpList.clear();
		tmpList.add(1); tmpList.add(9); tmpList.add(10); tmpList.add(11);tmpList.add(6);
		registeredUsers.add(new UserBean("Maria Herzog","mariaherzog@gmx.de","123456","123456","resources/images/userPics/mariaherzog.jpg",3.0f,2.5f,4.5f,2.5f,4,
				"Hey :). Ich bin begeisterte Hobby-Designerin und führe meinen eigenen Blog. Besonders die Farbenlehre und die Bedeutung von Kleidung für den Menschen interessiert mich sehr!",
				tmpList				
				));
		tmpList.clear();
		tmpList.add(3); tmpList.add(7); tmpList.add(8);
		registeredUsers.add(new UserBean("Sven Austerlitz","austerlitz.s@gmail.com","123456","123456","resources/images/userPics/svenausterlitz.jpg",4.0f,1.5f,3.0f,5.0f,6,
				"Zurzeit studiere ich Physik, was mir sehr viel Spaß bereitet. Aber auch außerhalb des Studiums bilde ich mich sehr gerne weiter und teile dieses Wissen mit allen, die es interessiert.",
				tmpList));
		
		/*
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(1); tmpList.add(5); tmpList.add(6); tmpList.add(7); tmpList.add(9);
		registeredUsers.add(new UserBean(	"test","test@gmail.com","test","test",
											"resources/images/userPics/Profilepic.jpg",
											3.0f,4.0f,5.0f,3.5f,7,
											"Dies ist eine Testbeschreibung, in der der Benutzer sich selbst vorstellt und eine kurze Übersicht über seine Person gibt.",
											tmpList));
											*/
		allUsers = registeredUsers;
		
	}
	
	public UserBean getUserByUserName(String userName) {
		for(UserBean curUser : allUsers) {
			if(userName.equals(curUser.getUserName())) {
				return curUser;
			}
		}
		return null;
	}
	
	public static ArrayList<UserBean> getAllUsers () {
		
		return allUsers;
	}
	
//	public static void setAllUsers(ArrayList<UserBean> allUsers) {
//		this.allUsers = allUsers;
//	}
	
	public static void addUsertoAllUsers (UserBean newUser) {
		
		allUsers.add(newUser);
	}
	
	public void deleteUserFromAllUsers(String userToDelete) {
		
		for(int j = 0; j < allUsers.size(); j++)
		{
		    UserBean obj = allUsers.get(j);

		    if(obj.getUserName().equals(userToDelete)){
		       //found, delete.
		        allUsers.remove(j);
		        return;
		    }

		}
		
//		
//		for(UserBean curUser : allUsers) {
//			if(userToDelete.equals(curUser.getUserName())) {
//				allUsers.remove(curUser);
//			}
//		}
	}
			

	public ArrayList<UserBean> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(ArrayList<UserBean> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}	
	
}