package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ListControllerBean implements Serializable {

	// list with all products
	private ArrayList<ProductBean> exampleProducts;
	// list with all products containing the search filter
	private ArrayList<ProductBean> searchProducts;

	private String searchFilter = "";

	public enum Filter {
		POPULAR, LATEST
	}

	private Filter sortFilter = Filter.POPULAR;
	private Comparator<ProductBean> compLatest;
	private Comparator<ProductBean> compPopular;
	private Map<Filter, Comparator<ProductBean>> compMap = new HashMap<ListControllerBean.Filter, Comparator<ProductBean>>();
	private int rating = 0;

	public ListControllerBean() {
		exampleProducts = new ArrayList<ProductBean>();
		searchProducts = new ArrayList<ProductBean>();

		// dummy data

		exampleProducts.add(new ProductBean("Die schönsten Filter für Instagram","resources/images/productPics/big/79H.jpg",2,10, 
				new String[] {"Foto","Filter","Instagram","Oldschool"},
				"Wer immer schon wissen wollten wie man sich von der Masse duch kreativen Einsatz von hippen Filtern abheben kann ist hier genau richtig", 
				new GregorianCalendar(14,2,13),UserListBean.getAllUsers().get(1),"Fotos",""));
		exampleProducts.add(new ProductBean("Fahrrad fahren für Hipster","resources/images/productPics/big/88H.jpg",3,500,
				new String[] {"Sport", "Fahrrad", "Hipster","Alternativ"},
				"Für alle, die auch beim Fahrradfahren Individualität und Style zeigen wollen.",new GregorianCalendar(13,5,13),
				UserListBean.getAllUsers().get(0),"Sport",""));
		exampleProducts.add(new ProductBean("Die besten Stücke für den Posaunenchor","resources/images/productPics/big/100H.jpg",4,30,
				new String[] {"Musik","Posaune","Musikstück","Bläser"},
				"Die schönster Stücke für den klassischen 15-stimmigen Posaunenchor wurden hier liebevoll gesammelt und aufbereitet",
				new GregorianCalendar(14,5,11),UserListBean.getAllUsers().get(2),"Kunst",""));
		exampleProducts.add(new ProductBean("Theater für Dummies","resources/images/productPics/big/103H.jpg",1,22,
				new String[] {"Theater","Kunst","Anfänger","Kurs"},
				"Wenn du noch nie auf der Bühne standest, aber schon immer mal ausprobieren wolltest, wie es ist in eine ander Rolle zu schlüpfen passt diese Veranstaltung perfekt zu dir",
				new GregorianCalendar(14,1,22),UserListBean.getAllUsers().get(0),"Kunst",""));
		exampleProducts.add(new ProductBean("Bahnfahren leicht gemacht","resources/images/productPics/big/90H.jpg",2.5f,10,
				new String[] {"Bahn","Mobilität","sparen"},
				"Sie verstehen immer nur Bahnhof, kommen nie rechtzeitig an und zahlen Unsummen? Mit diesen einfachen Tricks gehören diese Probleme der Vergangenheit an!"
				,new GregorianCalendar(14,6,16),UserListBean.getAllUsers().get(0),"Reisen",""));
		exampleProducts.add(new ProductBean("Dias in der Neuzeit","resources/images/productPics/big/83H.jpg",5,10,
				new String [] {"Bild","Dia","modern"},
				"Tausende Dias im Schrank und keine Ahnung wohin damit? In diesem Kurs zeige ich Ihnen wie sie ihre Schätze digitalisieren können",
				new GregorianCalendar(14,1,2),UserListBean.getAllUsers().get(1),"Foto",""));
		exampleProducts.add(new ProductBean("10 tolle Tipps für Oldtimer-Fans","resources/images/productPics/big/95H.jpg",2,10,
				new String[] {"Auto","Oldtimer","Tipps","Reparatur","Do-it-yourself"},
				"Früher war alles besser. Damit Sie auch noch heute die Meisterwerke aus dem 20. Jahrhundert bewundern können, müssen Sie auf einiges achten",
				new GregorianCalendar(14,5,19),UserListBean.getAllUsers().get(2),"Auto",""));
		exampleProducts.add(new ProductBean("Lustige Witze für zwischendurch","resources/images/productPics/big/78H.jpg",4.5f,15,
				new String [] {"Humor","Witze","Unterhaltung"},
				"Stressiges Studium? Mit diesen Witzen wird ihr Tag noch gerettet" ,
				new GregorianCalendar(14,2,11),UserListBean.getAllUsers().get(2),"Kunst",""));
		exampleProducts.add(new ProductBean("Romantischer Tangotanz","resources/images/productPics/big/82H.jpg",3,10,
				new String[] {"Tanz","Romantik","Tango","Sport"},
				"Tango für romantische Stunden.",
				new GregorianCalendar(14,5,26),UserListBean.getAllUsers().get(1),"Tanzen",""));
		exampleProducts.add(new ProductBean("Moderne Kunst und ihre Tücken","resources/images/productPics/big/85H.jpg",1.5f,3,
				new String[] {"Kunst","Modern","Interpretation"},
				"Die avantgardistische Kunst erscheint zunächst als trostlose Metapher von Einfallslosigkeit und Absurdität. Doch dieser Schein trügt...",
				new GregorianCalendar(14,4,6),UserListBean.getAllUsers().get(1),"Kunst",""));
		exampleProducts.add(new ProductBean("Fashion-Accessoires zum Selbermachen","resources/images/productPics/big/97H.jpg",4,10,
				new String [] {"Fashion","Mode","Do-it-yourself"},
				"Modebewusstsein aber schlechte finanzielle Lage? Dass wenig Geld kein Ausschlusskriterium für Stil sein muss zeige ich mit diesen einfachen Mode-Hacks",
				new GregorianCalendar(14,1,17),UserListBean.getAllUsers().get(1),"Mode",""));
		
		

		// init sort filter
		compLatest = new Comparator<ProductBean>() {

			@Override
			public int compare(ProductBean o1, ProductBean o2) {

				return o1.getSubmissiondate().compareTo(o2.getSubmissiondate());
			}

		};
		compPopular = new Comparator<ProductBean>() {

			@Override
			public int compare(ProductBean o1, ProductBean o2) {

				float change1 = o1.getRating();
				float change2 = o2.getRating();
				if (change1 < change2)
					return -1;
				if (change1 > change2)
					return 1;
				return 0;
			}

		};

		compMap.put(Filter.LATEST, compLatest);
		compMap.put(Filter.POPULAR, compPopular);

		sortHandler();

	}

	public ProductBean getProductsById(int Id) {
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getId() == Id) {
				return curProduct;
			}
		}
		return null;

	}

	public ArrayList<ProductBean> getProductsByAuthor(String author) {
		ArrayList<ProductBean> authorproducts = new ArrayList<ProductBean>();
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getAuthor().getUserName().equals(author)) {
				authorproducts.add(curProduct);
			}
		}
		return authorproducts;

	}

	public ArrayList<ProductBean> getProductsByTag(String tag) {
		ArrayList<ProductBean> tagproducts = new ArrayList<ProductBean>();

		for (ProductBean curProduct : exampleProducts) {

			if (Arrays.asList(curProduct.getTags()).contains(tag)) {
				tagproducts.add(curProduct);
			}
		}
		return tagproducts;

	}

	public void addProduct(ProductBean newProduct) {
		exampleProducts.add(newProduct);
	}

	public void deleteProduct(int productToDelete) {

		for (int j = 0; j < exampleProducts.size(); j++) {
			ProductBean obj = exampleProducts.get(j);

			if (obj.getId() == productToDelete) {
				// found, delete.
				exampleProducts.remove(j);
				return;
			}

		}
		// for(ProductBean curUser : exampleProducts) {
		// if(productToDelete == curUser.getId()) {
		// exampleProducts.remove(curUser);
		// }
		// }
	}

	// search
	/**
	 * Add these products to the search products list, which contain the search
	 * filter.
	 */
	public void searchHandler() {

		// clear search result
		searchProducts.clear();

		// return if search string is empty
		if (searchFilter.isEmpty()) {
			return;
		}

		// search without case sensitivity
		searchFilter = searchFilter.toLowerCase();

		try {

			for (ProductBean pb : exampleProducts) {

				if (pb.getProductName().toLowerCase().contains(searchFilter)
						|| searchInTags(pb.getTags(), searchFilter)) {

					searchProducts.add(pb);

				}

			}

		} catch (Exception e) {
			System.err.println("Error while handle search request!");
		}

	}

	/**
	 * Search for the given search filter in the given tag array.
	 * 
	 * @param tags
	 *            Array with tags.
	 * @param searchFilter
	 *            The search filter which should be found.
	 * @return True if at least one of the tags contains the search filter.
	 *         Otherwise return false.
	 */
	private boolean searchInTags(String[] tags, String searchFilter) {

		boolean found = false;

		for (String tag : tags) {

			if (tag.toLowerCase().contains(searchFilter)) {

				found = true;
				break;

			}

		}

		return found;

	}

	/**
	 * @return True if there is at least one item which contains the search
	 *         filter. Otherwise return false.
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

	// sort
	/**
	 * Sort product list with current sort filter.
	 */
	private void sortHandler() {

		try {

			Collections.sort(exampleProducts,
					Collections.reverseOrder(compMap.get(sortFilter)));

		} catch (Exception e) {
			System.err
					.println("Sorting failed. Check if there is a comparator in the comparator map for sort filter "
							+ sortFilter);
		}

	}

	/**
	 * Set the current sort filter to the given filter.
	 * 
	 * @param filter
	 *            Ordinal of filter enum.
	 * @return Empty string for JSF command button.
	 */
	public String setSortFilter(String filter) {

		if (Integer.valueOf(filter) != sortFilter.ordinal()) {
			sortFilter = Filter.values()[Integer.valueOf(filter)];
			sortHandler();
		}

		return "";
	}

	/**
	 * Return the CSS active class name if the given filter is equal to the
	 * current sort filter. Otherwise return an empty string.
	 * 
	 * @param filter
	 *            Ordinal of filter enum.
	 * @return The CSS active class name if the given filter is equal to the
	 *         current sort filter. Otherwise return an empty string.
	 */
	public String isFilterSelected(int filter) {

		if (filter == sortFilter.ordinal()) {
			return "active";
		} else {
			return "";
		}
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

	public Filter getSortFilter() {
		return sortFilter;
	}

	public void setCurrentFilter(Filter sortFilter) {
		this.sortFilter = sortFilter;
	}

	public int getRating() {
		return rating;
	}

}