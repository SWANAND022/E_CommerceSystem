package com.db.pojo;

public class Product {
	
	private Integer productId;
	private String productName;
	private String productType;
	private Double price;
	private Integer quantityInStock;
	private Double rating;
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Product(String productName, String productType, Double price, Integer quantityInStock, Double rating,
			String description) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.rating = rating;
		this.description = description;
	}



	public Product(Integer productId, String productName, String productType, Double price, Integer quantityInStock,
			Double rating, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.rating = rating;
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nProduct Id=" + productId + "\nProduct Name=" + productName + "\nProduct Type=" + productType
				+ "\nPrice=" + price + "Quantity In Stock=" + quantityInStock + "\nRating=" + rating + "\nDescription="
				+ description;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
