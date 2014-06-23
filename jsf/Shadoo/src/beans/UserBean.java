package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

//	@javax.persistence.Id
//    @javax.persistence.GeneratedValue(strategy=GenerationType.AUTO)//, generator="my_runway_seq_gen")
//	@SequenceGenerator(name="my_runway_seq_gen", sequenceName="MY_RUNWAY_SEQ")
	private int id;
	
	private String userName;
	private String email;
	private String password;
	private String passwordConfirm;
	private String imageUrl = "";
	private float rating = 0.0f;
	private int ratingamount = 0;
	private String description = "";
	private ArrayList<ProductBean> uploadedProducts = new ArrayList<ProductBean>();
	

	public UserBean() {
		
	}
	
	public UserBean(String userName, String email, String password, String passwordConfirm) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	
	public UserBean(int id, String userName, String email, String password,
			String passwordConfirm, String imageUrl, float rating,
			int ratingamount, String description,
			ArrayList<ProductBean> uploadedProducts) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.ratingamount = ratingamount;
		this.description = description;
		this.uploadedProducts = uploadedProducts;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRatingamount() {
		return ratingamount;
	}

	public void setRatingamount(int ratingamount) {
		this.ratingamount = ratingamount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<ProductBean> getUploadedProducts() {
		return uploadedProducts;
	}

	public void setUploadedProducts(ArrayList<ProductBean> uploadedProducts) {
		this.uploadedProducts = uploadedProducts;
	}

}
