package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import beans.ShareController.MediaTypes;

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

		exampleProducts
				.add(new ProductBean(
						"Die schönsten Filter für Instagram",
						"resources/images/productPics/big/79H.jpg",
						2,
						10,
						new String[] { "Foto", "Filter", "Instagram",
								"Oldschool" },
						"Wer immer schon wissen wollte wie man sich von der Masse duch kreativen Einsatz von hippen Filtern abheben kann ist hier genau richtig.",
						new GregorianCalendar(14, 2, 13),
						UserListBean.getAllUsers().get(1),
						"Fotos",
						"<script async class=\"speakerdeck-embed\" data-id=\"cf573f0088210130c6c3123138094421\" data-ratio=\"1.33333333333333\" src=\"//speakerdeck.com/assets/embed.js\"></script>",
						MediaTypes.SLIDES));
		exampleProducts
				.add(new ProductBean(
						"Fahrrad fahren für Hipster",
						"resources/images/productPics/big/88H.jpg",
						3,
						500,
						new String[] { "Sport", "Fahrrad", "Hipster",
								"Alternativ" },
						"Für alle, die auch beim Fahrradfahren Individualität und Style zeigen wollen.",
						new GregorianCalendar(13, 5, 13),
						UserListBean.getAllUsers().get(0),
						"Sport",
						"<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/EZ2C3GsXpxA\" frameborder=\"0\" allowfullscreen></iframe>",
						MediaTypes.VIDEO));
		exampleProducts
				.add(new ProductBean(
						"Die besten Stücke für den Posaunenchor",
						"resources/images/productPics/big/100H.jpg",
						4,
						30,
						new String[] { "Musik", "Posaune", "Musikstück",
								"Bläser" },
						"Die schönsten Stücke für den klassischen 15-stimmigen Posaunenchor wurden hier liebevoll gesammelt und aufbereitet.",
						new GregorianCalendar(14, 5, 11),
						UserListBean.getAllUsers().get(2),
						"Kunst",
						"<iframe width=\"100%\" height=\"450\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/playlists/4624185&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true\"></iframe>",
						MediaTypes.AUDIO));
		exampleProducts
				.add(new ProductBean(
						"Theater für Dummies",
						"resources/images/productPics/big/103H.jpg",
						1,
						22,
						new String[] { "Theater", "Kunst", "Anfänger", "Kurs" },
						"Wenn du noch nie auf der Bühne standest, aber schon immer mal ausprobieren wolltest, wie es ist in eine andere Rolle zu schlüpfen passt diese Veranstaltung perfekt zu dir!",
						new GregorianCalendar(14, 1, 22), UserListBean
								.getAllUsers().get(0), "Kunst", "", MediaTypes.EVENT));
		exampleProducts
				.add(new ProductBean(
						"Bahnfahren leicht gemacht",
						"resources/images/productPics/big/90H.jpg",
						2.5f,
						10,
						new String[] { "Bahn", "Mobilität", "sparen" },
						"Sie verstehen immer nur Bahnhof, kommen nie rechtzeitig an und zahlen Unsummen? Mit diesen einfachen Tricks gehören diese Probleme der Vergangenheit an!",
						new GregorianCalendar(14, 5, 16),
						UserListBean.getAllUsers().get(0),
						"Reisen",
						"<script async class=\"speakerdeck-embed\" data-id=\"5172793011370130a40122000a8f8767\" data-ratio=\"1.33333333333333\" src=\"//speakerdeck.com/assets/embed.js\"></script>",
						MediaTypes.SLIDES));
		exampleProducts
				.add(new ProductBean(
						"Dias in der Neuzeit",
						"resources/images/productPics/big/83H.jpg",
						5,
						10,
						new String[] { "Bild", "Dia", "modern" },
						"Tausende Dias im Schrank und keine Ahnung wohin damit? In diesem Kurs zeige ich Ihnen wie Sie ihre Schätze digitalisieren können.",
						new GregorianCalendar(14, 1, 2),
						UserListBean.getAllUsers().get(1),
						"Foto",
						"<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/vlTR22pTHyw\" frameborder=\"0\" allowfullscreen></iframe>",
						MediaTypes.VIDEO));
		exampleProducts
				.add(new ProductBean(
						"10 tolle Tipps für Oldtimer-Fans",
						"resources/images/productPics/big/95H.jpg",
						2,
						10,
						new String[] { "Auto", "Oldtimer", "Tipps",
								"Reparatur", "Do-it-yourself" },
						"Früher war alles besser. Damit Sie auch noch heute die Meisterwerke aus dem 20. Jahrhundert bewundern können, müssen Sie auf einiges achten.",
						new GregorianCalendar(14, 5, 19),
						UserListBean.getAllUsers().get(2),
						"Auto",
						"<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/xpdwj7bzE18?rel=0\" frameborder=\"0\" allowfullscreen></iframe>",
						MediaTypes.VIDEO));
		exampleProducts
				.add(new ProductBean(
						"Lustige Witze für zwischendurch",
						"resources/images/productPics/big/78H.jpg",
						4.5f,
						15,
						new String[] { "Humor", "Witze", "Unterhaltung" },
						"Stressiges Studium? Mit diesen Witzen wird ihr Tag noch gerettet.",
						new GregorianCalendar(14, 2, 11),
						UserListBean.getAllUsers().get(2),
						"Kunst",
						"<iframe src=\"//www.slideshare.net/slideshow/embed_code/18943524\" width=\"427\" height=\"356\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" style=\"border:1px solid #CCC; border-width:1px 1px 0; margin-bottom:5px; max-width: 100%;\" allowfullscreen> </iframe> <div style=\"margin-bottom:5px\"> <strong> <a href=\"https://de.slideshare.net/grbooks/jokes-for-kids-slideshow\" title=\"Jokes for Kids: 21 Clean and Funny Jokes for Kids!\" target=\"_blank\">Jokes for Kids: 21 Clean and Funny Jokes for Kids!</a> </strong> from <strong><a href=\"http://www.slideshare.net/grbooks\" target=\"_blank\">grbooks</a></strong> </div>",
						MediaTypes.SLIDES));
		exampleProducts.add(new ProductBean("Romantischer Tangotanz",
				"resources/images/productPics/big/82H.jpg", 3, 10,
				new String[] { "Tanz", "Romantik", "Tango", "Sport" },
				"Tango für romantische Stunden.", new GregorianCalendar(14, 5,
						26), UserListBean.getAllUsers().get(1), "Tanzen", "",
				MediaTypes.EVENT));
		exampleProducts
				.add(new ProductBean(
						"Moderne Kunst und ihre Tücken",
						"resources/images/productPics/big/85H.jpg",
						1.5f,
						3,
						new String[] { "Kunst", "Modern", "Interpretation" },
						"Die avantgardistische Kunst erscheint zunächst als trostlose Metapher von Einfallslosigkeit und Absurdität. Doch dieser Schein trügt...",
						new GregorianCalendar(14, 4, 6), UserListBean
								.getAllUsers().get(1), "Kunst", "", MediaTypes.SCRIPT));
		exampleProducts
				.add(new ProductBean(
						"Fashion-Accessoires zum Selbermachen",
						"resources/images/productPics/big/97H.jpg",
						4,
						10,
						new String[] { "Fashion", "Mode", "Do-it-yourself" },
						"Modebewusstsein aber schlechte finanzielle Lage? Dass wenig Geld kein Ausschlusskriterium für Stil sein muss zeige ich mit diesen einfachen Mode-Hacks",
						new GregorianCalendar(14, 1, 17),
						UserListBean.getAllUsers().get(1),
						"Mode",
						"<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/8BLSu7GPu-E\" frameborder=\"0\" allowfullscreen></iframe>",
						MediaTypes.VIDEO));

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
	public String getCurProductRelativeDate (ProductBean curProd)
	{
		Calendar submissiondate= curProd.getSubmissiondate();
		

		    int subyear = submissiondate.get(Calendar.YEAR);
		    if(subyear > 2000) {
		    	subyear = submissiondate.get(Calendar.YEAR) - 2000;
		    }

		    int submonth = submissiondate.get(Calendar.MONTH);
		    int subday = submissiondate.get(Calendar.DAY_OF_MONTH);
		    
		    
		    Calendar cal = Calendar.getInstance();
		    int curday = cal.get(Calendar.DAY_OF_MONTH);
		    int curmonth = cal.get(Calendar.MONTH);
		    int curyear;
		    
		    if(cal.get(Calendar.YEAR) > 2000) {
		    	curyear = cal.get(Calendar.YEAR) -2000;
		    }else{
		    	curyear = cal.get(Calendar.YEAR);
		    }
		    
		    
		    
		   

		    if(subyear == curyear)
		    {
		       	if(submonth==curmonth)
		    	{
		      		if(subday==curday)
		    		{
		    			return "heute";
		    		}
		    		if (curday-subday == 1)
		    		{
		    			return "vor "+ (curday-subday) + " Tag";
		    		}
		    		return "vor " + (curday-subday) + " Tagen";
		    	}
				if (curmonth-submonth == 1)
	    		{
					return "vor " + (curmonth-submonth) + " Monat";
	    		}
		    	return "vor " + (curmonth-submonth) + " Monaten";
		    }
		    if (curyear-subyear == 1)
    		{
				return "vor " + (curyear-subyear) + " Jahr";
    		}
		    return "vor " + (curyear-subyear) + " Jahren";

	}
	

	public String getCurProductMediaType(ProductBean curProd) {

		MediaTypes mediatype = curProd.getMediatype();
		String result = "";
		System.out.println(curProd.getProductName() + " mediatype: " + mediatype);
		
		if (mediatype == MediaTypes.SLIDES)
			result = "<img class=\"\" src=\"resources/images/icons/grau/sd_slides.png\" />";
		else if (mediatype == MediaTypes.SCRIPT)
			result = "<img class=\"\" src=\"resources/images/icons/grau/sd_script.png\" />";
		else if (mediatype == MediaTypes.AUDIO)
			result = "<img class=\"\" src=\"resources/images/icons/grau/sd_audio.png\" />";
		else if (mediatype == MediaTypes.VIDEO)
			result = "<img class=\"\" src=\"resources/images/icons/grau/sd_video.png\" />";
		else if (mediatype == MediaTypes.EVENT)
			result = "<img class=\"\" src=\"resources/images/icons/grau/sd_calendar.png\" />";

		return result;

	}

	public ProductBean getProductsById(int Id) {
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getId() == Id) {
				return curProduct;
			}
		}
		return null;

	}

	public ArrayList<ProductBean> getProductsBySubject(String subject) {

		ArrayList<ProductBean> temp = new ArrayList<ProductBean>();
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getCategory().toLowerCase()
					.equals(subject.toLowerCase())) {
				temp.add(curProduct);
			}
		}
		return temp;

	}

	public boolean foundProductsBySubject(String subject) {

		boolean temp = false;
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getCategory().toLowerCase()
					.equals(subject.toLowerCase())) {
				temp = true;
			}
		}
		return temp;

	}
	
	public boolean existsProduct(String id) {
		
		boolean temp = false;
		int intId = 0;
		
		try {
			intId = Integer.parseInt(id);
		}catch(NumberFormatException nfe) {
			return false;
		}
		
		for (ProductBean curProduct : exampleProducts) {
			if (curProduct.getId() == intId) {
				temp = true;
			}
		}
		return temp;

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
	public void sortHandler() {

		try {
			System.out.println("Sorting products.... ");
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