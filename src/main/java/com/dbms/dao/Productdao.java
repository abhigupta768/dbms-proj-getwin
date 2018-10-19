package com.dbms.dao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.dbms.model.Product;
public interface Productdao {
	@Autowired
	public void delete(Long product_id);
	public Product getProduct(Long product_id);
	public void saveOrUpdateProduct(Product product);
	public List<Product> showProducts();
	public void proUpdate(Product product);
}