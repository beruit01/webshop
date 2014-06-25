package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class RatingBean implements Serializable {
	
	private float ratingProduct = 0.0f;
	private float ratingRhetoric = 0.0f;
	private float ratingMaterials = 0.0f;
	private float ratingKnowledge = 0.0f;
	private float ratingCommitment = 0.0f;
	
	private ProductBean pb;
	
	@Inject
	ListControllerBean listControllerBean;
	
	@Inject
	UserListBean userListBean;
	
	@Inject
	ProductBean productBean;
	
	@Inject
	UserBean userBean;


	public String setRatings() {
		
//		System.out.println(listControllerBean.getExampleProducts().g);
		
		System.out.println("Rating vorher: " + productBean.getRating());
		productBean.setratingamount(productBean.getratingamount() + 1);
		productBean.setRating(((productBean.getratingamount()-1)*productBean.getRating() + ratingProduct) / productBean.getratingamount());
		System.out.println("Rating nachher: " + productBean.getRating());
		
		listControllerBean.deleteProduct(productBean.getId());
		listControllerBean.addProduct(productBean);
		
		userBean.setRatingamount(userBean.getRatingamount() + 1);
		userBean.setRatingRhetoric(((userBean.getRatingamount()-1)*userBean.getRatingRhetoric() + ratingRhetoric) / userBean.getRatingamount());
		userBean.setRatingMaterials(((userBean.getRatingamount()-1)*userBean.getRatingMaterials() + ratingMaterials) / userBean.getRatingamount());
		userBean.setRatingKnowledge(((userBean.getRatingamount()-1)*userBean.getRatingKnowledge() + ratingKnowledge) / userBean.getRatingamount());
		userBean.setRatingCommitment(((userBean.getRatingamount()-1)*userBean.getRatingCommitment() + ratingCommitment) / userBean.getRatingamount());
		
		userListBean.deleteUserFromAllUsers(userBean.getUserName());
		UserListBean.addUsertoAllUsers(userBean);
		
//		ArrayList<UserBean> userList = UserListBean.getAllUsers();
//		for(UserBean curUser : userList) {
//			if(userBean.getUserName().equals(curUser.getUserName())) {
//				userList.set(userList.indexOf(curUser), userBean);
//				break;
//			}
//		}
//		UserListBean.setAllUsers(userList);
		
		return "index";
	}
	
	public String initializeRating() {
		
		int id = Integer.parseInt( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id") );

		ProductBean curProd = listControllerBean.getProductsById( id );
		
		System.out.println("curr: " + curProd);
		System.out.println(curProd.getAuthor());
		productBean = curProd;
		userBean = curProd.getAuthor();
		return "rating";
	}
	
	public String getCurProductRating(ProductBean curProd) {
		
		System.out.println("curProd: " + curProd);
		float ratingValue = curProd.getRating();
		//System.out.println(curProd.getProductName() + " ratingValue: " + ratingValue);
//		String result ="<div class=\"sd-rating clearfix\">";
//		String result = "";
//		
//		if (ratingValue < 0.25) result += "<div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 0.75) result += "<div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 1.25) result += "<div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 1.75) result += "<div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 2.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 2.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 3.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 3.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 4.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div>";
//		else if (ratingValue <= 4.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div>";
//		else if (ratingValue <=  5.0) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div>";
//		else result += "<div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
			
//		return result;
		
		return getCurRating(ratingValue);
		
	}
	
	public String getCurAuthorRating(UserBean curUser, int type) {
	
		float ratingValue;
		
		switch(type) {
		case 1:	ratingValue = curUser.getRatingRhetoric(); break;
		case 2:	ratingValue = curUser.getRatingMaterials(); break;
		case 3:	ratingValue = curUser.getRatingKnowledge(); break;
		case 4:	ratingValue = curUser.getRatingCommitment(); break;
		default:ratingValue = 0; break;
		}
		
		return getCurRating(ratingValue);
		
	}
	
	public String getCurRating(float ratingValue) {
		
		String result = "";
		
		if (ratingValue < 0.25) result += "<div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 0.75) result += "<div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 1.25) result += "<div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 1.75) result += "<div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 2.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 2.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 3.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 3.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 4.25) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart00\"></div>";
		else if (ratingValue <= 4.75) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart05\"></div>";
		else if (ratingValue <=  5.0) result += "<div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div><div class=\"heart10\"></div>";
		else result += "<div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div><div class=\"heart00\"></div>";
			
		return result;
		
	}
	
	
	public float getRatingProduct() {
		return ratingProduct;
	}

	public void setRatingProduct(float ratingProduct) {
		this.ratingProduct = ratingProduct;
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

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	

}
