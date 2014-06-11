package beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductBean implements Serializable {

	private String productName;
	private String imageUrl;
	private float rating;
	
	public ProductBean(String productName, String imageUrl, float rating)
	{
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.rating = rating;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
}
