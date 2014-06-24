package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {

	private String userName;
	private String email;
	private String password;
	private String passwordConfirm;
	private String imageUrl = "";
	private float ratingRhetoric = 0.0f;
	private float ratingMaterials = 0.0f;
	private float ratingKnowledge = 0.0f;
	private float ratingCommitment = 0.0f;
	private int ratingamount = 0;
	private String description = "";
	private ArrayList<Integer> uploadedProducts;

	public UserBean() {

	}

	public UserBean(String userName, String email, String password,
			String passwordConfirm) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		
		imageUrl = "";
		ratingRhetoric = 0.0f;
		ratingMaterials = 0.0f;
		ratingKnowledge = 0.0f;
		ratingCommitment = 0.0f;
		ratingamount = 0;
		description = "";
		uploadedProducts = new ArrayList<Integer>();
		
		UserListBean.addUsertoAllUsers(this);
	}

	public UserBean(String userName, String email, String password,
			String passwordConfirm, String imageUrl, float ratingRhetoric,
			float ratingMaterials, float ratingKnowledge,
			float ratingCommitment, int ratingamount, String description,
			ArrayList<Integer> uploadedProducts) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.imageUrl = imageUrl;
		this.ratingRhetoric = ratingRhetoric;
		this.ratingMaterials = ratingMaterials;
		this.ratingKnowledge = ratingKnowledge;
		this.ratingCommitment = ratingCommitment;
		this.ratingamount = ratingamount;
		this.description = description;
		this.uploadedProducts = uploadedProducts;

		UserListBean.addUsertoAllUsers(this);
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getRatingRhetoric() {
		return ratingRhetoric;
	}

	public void setRatingRhetoric(float ratingRhetoric) {
		this.ratingRhetoric = ratingRhetoric;
	}

	public float getRatingMaterials() {
		return ratingMaterials;
	}

	public void setRatingMaterials(float ratingMaterials) {
		this.ratingMaterials = ratingMaterials;
	}

	public float getRatingKnowledge() {
		return ratingKnowledge;
	}

	public void setRatingKnowledge(float ratingKnowledge) {
		this.ratingKnowledge = ratingKnowledge;
	}

	public float getRatingCommitment() {
		return ratingCommitment;
	}

	public void setRatingCommitment(float ratingCommitment) {
		this.ratingCommitment = ratingCommitment;
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

	public ArrayList<Integer> getUploadedProducts() {
		return uploadedProducts;
	}

	public void setUploadedProducts(ArrayList<Integer> uploadedProducts) {
		this.uploadedProducts = uploadedProducts;
	}

}
