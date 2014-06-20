package beans;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductBean implements Serializable {

	private String productName;
	private String imageUrl;
	private float rating;
	private int ratingamount;
	private String [] tags;
	private String description;
	private Date submissiondate;
	
	


	public ProductBean(String productName, String imageUrl, float rating, int ratingamount, String [] tags, String description, Date submissiondate)
	{
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.ratingamount = ratingamount;
		this.tags = tags;
		this.description = description;
		this.submissiondate = submissiondate;
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
	public int getratingamount() {
		return ratingamount;
	}

	public void setratingamount(int ratingamount) {
		this.ratingamount = ratingamount;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSubmissiondate() {
		return submissiondate;
	}

	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}
	
}
