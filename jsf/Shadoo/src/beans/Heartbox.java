package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Heartbox implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private static List<ProductBean> items = new ArrayList<ProductBean>();

	
	public Heartbox() {	
		
	}
	
	/**
	 * Add a new item to the heartbox.
	 * @param item Product to add.
	 * @return Empty string for JSF command button.
	 */
	public String addItem(ProductBean item) {
		if(!(items.contains(item)))
		items.add(item);
		return "";
	}
	
	/**
	 * Remove an item from the heartbox.
	 * @param productName Product name of product to remove.
	 * @return Empty string for JSF command button.
	 */
	// TODO: Add unique identifier to product bean.
	public String removeItem(String productName) {
		
		for(ProductBean i: items) {
			if(i.getProductName().equals(productName)) {
				items.remove(i);
				break;
			}
		}
		
		return "";
	}
	
	/**
	 * @return True if heartbox is empty. Otherwise return false.
	 */
	public boolean isEmpty() {
		return items.size() <= 0;
	}
	
	
	
	public List<ProductBean> getItems() {
		return items;
	}
	public void setItems(List<ProductBean> items) {
		this.items = items;
	}
}
