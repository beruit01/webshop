package beans;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Controller {

	@Inject
	private ListControllerBean listControllerBean;

	@Inject
	private Heartbox heartbox;

	@Inject
	private Login login;

	public String addToHeartbox() {

		int id = Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id"));
		if (login.isLoggedIn()) {

			System.out.println("Add product to heartbox " + id);

			ProductBean temp = listControllerBean.getProductsById(id);
			heartbox.addItem(temp);

			return "heartbox";
		} else {
			return "login";
		}
	}

}