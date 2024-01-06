package com.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.db.pojo.Product;
import com.db.util.DButility;

public class ProductDaoImpl implements ProductDao{
	
	Connection con =null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs= null;
	
	@Override
	public Boolean addproduct(Product p) {
		
		try {
			con=DButility.makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sql="insert into ecommerce(productName, productType, price, quantityInStock, rating, description) values (?, ?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductType());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityInStock());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}

	@Override
	public Boolean updateproduct(Product p) {try {
		con=DButility.makeConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sql="update ecommerce set productName=?, productType=?, price=?, quantityInStock=?, rating=?, description=? where productId=?";
	
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, p.getProductName());
		ps.setString(2, p.getProductType());
		ps.setDouble(3, p.getPrice());
		ps.setInt(4, p.getQuantityInStock());
		ps.setDouble(5, p.getRating());
		ps.setString(6, p.getDescription());
		ps.setInt(7, p.getProductId());
		
		int i=ps.executeUpdate();
		if(i>0)
			return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;
	}

	@Override
	public Boolean deleteproduct(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> showAllProducts() {
		try {
			con=DButility.makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select * from ecommerce";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<Product>();
			
			while(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Product showProductById(Integer productId) {
		
		try {
			con=DButility.makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select * from ecommerce where productId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Product> searchByName(String productName) {
		
		try {
			con=DButility.makeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select * from ecommerce where productName like ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+productName+"%");
			
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<Product>();
			
			while(rs.next()) {
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
