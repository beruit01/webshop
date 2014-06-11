package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListControllerBean {

	private ArrayList<ProductBean> exampleProducts;
	private ArrayList<ProductBean> newestProducts;

	public ArrayList<ProductBean> getExampleProducts() {
		return exampleProducts;
	}


	public void setExampleProducts(ArrayList<ProductBean> exampleProducts) {
		this.exampleProducts = exampleProducts;
	}



	public ListControllerBean()
	{
		exampleProducts = new ArrayList<ProductBean>();
		
		// dummy data
		exampleProducts.add(new ProductBean("Die sch�nsten Filter f�r Instagram","resources/images/examplePics/79H.jpg",2,new Date(1389571200)));
		exampleProducts.add(new ProductBean("Fahrrad fahren f�r Hipster","resources/images/examplePics/88H.jpg",3,new Date(1405641600)));
		exampleProducts.add(new ProductBean("Die besten St�cke f�r den Posaunenchor","resources/images/examplePics/100H.jpg",4,new Date(1390521600)));
		exampleProducts.add(new ProductBean("Theater f�r Dummies","resources/images/examplePics/103H.jpg",1,new Date(1391472000)));
		exampleProducts.add(new ProductBean("Bahnfahren leicht gemacht","resources/images/examplePics/90H.jpg",2.5f,new Date(1394668800)));
		exampleProducts.add(new ProductBean("Dias in der Neuzeit","resources/images/examplePics/83H.jpg",5,new Date(1395100800)));
		exampleProducts.add(new ProductBean("10 tolle Tipps f�r Oldtimer-Fans","resources/images/examplePics/95H.jpg",2,new Date(1396915200)));
		exampleProducts.add(new ProductBean("Lustige Witze f�r zwischendurch","resources/images/examplePics/78H.jpg",4.5f,new Date(1397088000)));
		exampleProducts.add(new ProductBean("Romantischer Tangotanz","resources/images/examplePics/82H.jpg",3,new Date(1397174400)));
		exampleProducts.add(new ProductBean("Moderne Kunst und ihre T�cken","resources/images/examplePics/85H.jpg",1.5f,new Date(1398729600)));
		exampleProducts.add(new ProductBean("Fashion-Accessoires zum Selbermachen","resources/images/examplePics/97H.jpg",4, new Date(1399248000)));

	}
	
	
}