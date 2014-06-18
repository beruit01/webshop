package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Controller {

	private String labelFavClass = "btn btn-default btn-favourites";
	private String labelNewClass = "btn btn-default btn-newest";
	
	public String test() {
		System.out.println("Hallooooooooooooooooooooooooooooooooooooooooooooooooo");
		
//		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
//		UIComponent component = viewRoot.findComponent("test");
//		System.out.println(component.getClass());
		
		return "";
	}
	
	public String getLabelFavClass() {
		return labelFavClass;
	}
	public void setLabelFavClass(String labelFavClass) {
		this.labelFavClass = labelFavClass;
		System.out.println("favClass: " + labelFavClass);
	}
	public String getLabelNewClass() {
		return labelNewClass;
	}
	public void setLabelNewClass(String labelNewClass) {
		this.labelNewClass = labelNewClass;
		System.out.println("newClass: " + labelNewClass);
	}
	
}