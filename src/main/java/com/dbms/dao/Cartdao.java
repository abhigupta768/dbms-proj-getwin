package com.dbms.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.dbms.model.Cart;


public interface Cartdao {
	@Autowired
	public void saveCart(String username, Long pid);
	public List<Cart> showUserCart(String username);
	public void deleteCartEntry(String username, Long pid);
	public Long showPrice(String username);
	public Long getMaxQuantity(Long pid);
	public void updateCartEntry(Cart cart);
}
