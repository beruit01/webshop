package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductBean implements Serializable {

	private int id;
	private String productName;
	private String imageUrl;
	private float rating;
	private int ratingamount;
	private String [] tags;
	private String description;
	private Calendar submissiondate;
	private UserBean author;
	private String subject;
	private String embeddedcode;


	private static int nProducts = 0;
	
	public ProductBean() {
		nProducts++;
		this.id = nProducts;
	}
	
	public ProductBean(String productName, String imageUrl, float rating, int ratingamount, String [] tags,
			String description, Calendar submissiondate, UserBean author, String subject,String embeddedcode)
	{
		nProducts++;
		this.id = nProducts;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.ratingamount = ratingamount;
		this.tags = tags;
		this.description = description;
		this.submissiondate = submissiondate;
		this.author = author;
		this.subject = subject;
		this.embeddedcode = embeddedcode;
	}
	
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");			
		return (sdf.format(submissiondate.getTime()));
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

	public Calendar getSubmissiondate() {
		return submissiondate;
	}

	public void setSubmissiondate(Calendar submissiondate) {
		this.submissiondate = submissiondate;
	}
	
	public UserBean getAuthor() {
		return author;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	}

	public String getCategory() {
		return subject;
	}

	public void setCategory(String category) {
		this.subject = category;
	}
	public int getId() {
		return id;
	}

	public String getEmbeddedcode() {
		return embeddedcode;
	}

	public void setEmbeddedcode(String embeddedcode) {
		this.embeddedcode = embeddedcode;
	}
	
	
}
