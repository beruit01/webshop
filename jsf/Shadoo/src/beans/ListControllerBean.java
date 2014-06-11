package beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListControllerBean {

	private ArrayList<ProductBean> favouriteProducts;
	private ArrayList<ProductBean> newestProducts;

	public ArrayList<ProductBean> getFavouriteProducts() {
		return favouriteProducts;
	}


	public ArrayList<ProductBean> getNewestProducts() {
		return newestProducts;
	}


	public void setFavouriteProducts(ArrayList<ProductBean> favouriteProducts) {
		this.favouriteProducts = favouriteProducts;
	}


	public void setNewestProducts(ArrayList<ProductBean> newestProducts) {
		this.newestProducts = newestProducts;
	}


	public ListControllerBean()
	{
		favouriteProducts = new ArrayList<ProductBean>();
		
		// dummy data
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		favouriteProducts.add(new ProductBean("TestName","images/heart.png",3));
		
		newestProducts = new ArrayList<ProductBean>();
		
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
		newestProducts.add(new ProductBean("TestName","images/heart.png",3));
	}
	
	
}