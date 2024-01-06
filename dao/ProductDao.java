package com.db.dao;

import java.util.List;

import com.db.pojo.Product;

public interface ProductDao {
	
	public Boolean addproduct(Product p);
	public Boolean updateproduct(Product p);
	public Boolean deleteproduct(Integer productId);
	
	public List<Product> showAllProducts();
	public Product showProductById(Integer productId);
	public List<Product> searchByName(String productName);
	

}
