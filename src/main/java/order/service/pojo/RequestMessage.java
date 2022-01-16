package order.service.pojo;

import java.io.Serializable;

public class RequestMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7938618882481906427L;

	private String type;
	
	private Order order;
	
	private Product product;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	

}
