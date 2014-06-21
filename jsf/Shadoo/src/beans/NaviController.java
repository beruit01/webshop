package beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class NaviController implements Serializable {
	
	/**
	 * @return Highlight class name if pagename is equal to current page.
	 */
	public String getCurrentPage(String pagename) {
		
		// syntax: /pagename.xhtml
		String viewid = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		
		// remove leading slash
		viewid = viewid.substring(1);
		
		// remove trailing .xhtml
		viewid = (String) viewid.subSequence(0, viewid.length() - 6 );
		
		// return highlight class if page name is equal to current page
		if(viewid.contains(pagename)) {
			return "highlight";
		}else{
			return "";
		}
		
	}

}
