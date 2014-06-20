package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ListControllerBean implements Serializable {

	// list with all products
	private ArrayList<ProductBean> exampleProducts;
	// list with all products containing the search filter
	private ArrayList<ProductBean> searchProducts;
	
	private String searchFilter = "";
	
	
	
	public ListControllerBean()
	{
		exampleProducts = new ArrayList<ProductBean>();
		searchProducts = new ArrayList<ProductBean>();
		
		// dummy data
		exampleProducts.add(new ProductBean("Die schönsten Filter für Instagram","resources/images/examplePics/79H.jpg",2,10, 
				new String[] {"Foto","Filter","Instagram","Oldschool"},
				"Wer immer schon wissen wollten wie man sich von der Masse duch kreativen Einsatz von hippen Filtern abheben kann ist hier genau richtig", 
				new Date(1389571200)));
		exampleProducts.add(new ProductBean("Fahrrad fahren für Hipster","resources/images/examplePics/88H.jpg",3,500,
				new String[] {"Sport", "Fahrrad", "Hipster","Alternativ"},
				"Für alle, die auch beim Fahrradfahren Individualität und Style zeigen wollen.",new Date(1405641600)));
		exampleProducts.add(new ProductBean("Die besten Stücke für den Posaunenchor","resources/images/examplePics/100H.jpg",4,30,
				new String[] {"P"}
				
		new Date(1390521600)));
		exampleProducts.add(new ProductBean("Theater für Dummies","resources/images/examplePics/103H.jpg",1,new Date(1391472000)));
		exampleProducts.add(new ProductBean("Bahnfahren leicht gemacht","resources/images/examplePics/90H.jpg",2.5f,new Date(1394668800)));
		exampleProducts.add(new ProductBean("Dias in der Neuzeit","resources/images/examplePics/83H.jpg",5,new Date(1395100800)));
		exampleProducts.add(new ProductBean("10 tolle Tipps für Oldtimer-Fans","resources/images/examplePics/95H.jpg",2,new Date(1396915200)));
		exampleProducts.add(new ProductBean("Lustige Witze für zwischendurch","resources/images/examplePics/78H.jpg",4.5f,new Date(1397088000)));
		exampleProducts.add(new ProductBean("Romantischer Tangotanz","resources/images/examplePics/82H.jpg",3,new Date(1397174400)));
		exampleProducts.add(new ProductBean("Moderne Kunst und ihre Tücken","resources/images/examplePics/85H.jpg",1.5f,new Date(1398729600)));
		exampleProducts.add(new ProductBean("Fashion-Accessoires zum Selbermachen","resources/images/examplePics/97H.jpg",4, new Date(1399248000)));
		
	}
	
	/**
	 * Add these products to the search products list, which contain the search filter.
	 */
	public void searchHandler() {
		
		try {
			
			searchProducts.clear();
			
			for(ProductBean pb: exampleProducts ) {
				
				if( !searchFilter.isEmpty() && pb.getProductName().toLowerCase().contains(searchFilter.toLowerCase())) {
					searchProducts.add(pb);
				}
				
			}
			
		}catch(Exception e) {
			System.err.println("Error while hanlde search request!");
		}
		
	}
	
	/**
	 * @return True if there is at least one item which contains the search filter. Otherwise return false.
	 */
	public boolean itemsFoundContainingSearchFilter() {
		return searchProducts.size() > 0;
	}

	/**
	 * @return True if search filter is empty. Otherwise return false.
	 */
	public boolean isSearchFilterEmpty() {
		return searchFilter.length() == 0;
	}
	
	// getters and setters
	public ArrayList<ProductBean> getExampleProducts() {
		return exampleProducts;
	}
	public void setExampleProducts(ArrayList<ProductBean> exampleProducts) {
		this.exampleProducts = exampleProducts;
	}
	public ArrayList<ProductBean> getSearchProducts() {
		return searchProducts;
	}
	public void setSearchProducts(ArrayList<ProductBean> searchProducts) {
		this.searchProducts = searchProducts;
	}
	public String getSearchFilter() {
		return searchFilter;
	}
	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	
	
}