package beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import beans.ListControllerBean.Filter;

@Named
@RequestScoped
public class ShareController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public enum MediaTypes { VIDEO, AUDIO, SCRIPT, SLIDES, EVENT };
	private static MediaTypes type = MediaTypes.SCRIPT;
	private String title = "";
	private String description = "";
	private String subjectArea = "";
	private String embeddedCode = "";
	private String tags = "";
	private Part imagePath;
	
	@Inject
	private ListControllerBean listControllerBean;
	
	/**
	 * @return Highlight class name if media type is equal to current media type.
	 */
	public String getCurrentMediaType(String reqType) {
		
		if( Integer.parseInt(reqType) == type.ordinal() ) {
			return "highlight";
		}else{
			return "";
		}
		
	}
	
	/**
	 * Set current media type.
	 * @param type Ordinal as string. JSF allows only string attributes.
	 * @return Empt string for JSF command button.
	 */
	public String setCurrentMediaType(String newType) {
		
		type = MediaTypes.values()[Integer.valueOf(newType)];
		
		return "";
	}

	/**
	 * Save new product.
	 * @return Empty string for JSF command button.
	 */
	public String share() {
		
		System.out.println("share..");
		
		System.out.println("titel: " + title);
		System.out.println("beschreibung: " + description);
		System.out.println("embedded: " + embeddedCode);
		System.out.println("foto: " + imagePath);
		System.out.println("subject: " + subjectArea);
		
		// create new product
		ProductBean newProduct = new ProductBean();
		newProduct.setProductName( title );
		newProduct.setDescription( description );
		newProduct.setCategory( subjectArea );
		newProduct.setEmbeddedcode( embeddedCode );
		newProduct.setSubmissiondate( new GregorianCalendar() );
		
		
		// parse tags
		if( tags.length() > 0 ) {
			
			String[] tempTags = tags.split(",");
			
			if( tempTags.length > 0) {
				
				for(int i=0; i<tempTags.length; i++) {
					tempTags[i] = tempTags[i].trim();
				}

				newProduct.setTags(tempTags);
			}
			
		}
		
		// store image
		if( imagePath != null ) {
		
			try {
				
				String relativeWebPath = "/resources/upload";
				String absoluteDiskPath = "";
				String fsPath = "";
				String productPath = "resources/upload/";
				
				// get absolute path
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				ServletContext servletContext = (ServletContext) externalContext.getContext();
				absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
				
				// set paths
				fsPath = absoluteDiskPath + "/";
				productPath += getFilename(imagePath);
				
				System.out.println("[upload product image] Filesystem path: " + fsPath);
				System.out.println("[upload product image] Product path: " + productPath);
				
				// write image
				imagePath.write( fsPath + getFilename(imagePath));
				
				newProduct.setImageUrl(productPath);
				
				System.out.println("[upload product image] Uploaded file successfully!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			newProduct.setImageUrl("resources/images/productPics/big/default.jpg");
			
		}
		
		
		// TODO: store product in list
		listControllerBean.addProduct( newProduct );
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			System.err.println("Redirect failed!");
			e.printStackTrace();
		}
		
		
		// reset values
		title = "";
		description = "";
		subjectArea = "";
		embeddedCode = "";
		tags = "";
		imagePath = null;
		
		return "index";
	}
	private String getFilename(Part part) {
		String filename = "";
		for(String cd: part.getHeader("content-disposition").split(";")) {
			if(cd.trim().startsWith("filename")) {
				filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");				
			}
		}
		return filename;
	}
	
	
	public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
		
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part)value;
		
		if (!"image/jpeg".equals(file.getContentType())) {
			msgs.add(new FacesMessage("Bei der Datei handelt es sich nicht um ein Bild."));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}

	
	// getter and setter
	public MediaTypes getType() {
		return type;
	}
	public void setType(MediaTypes type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubjectArea() {
		return subjectArea;
	}
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}
	public String getEmbeddedCode() {
		return embeddedCode;
	}
	public void setEmbeddedCode(String embeddedCode) {
		this.embeddedCode = embeddedCode;
	}
	public Part getImagePath() {
		return imagePath;
	}
	public void setImagePath(Part imagePath) {
		this.imagePath = imagePath;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
