package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Cart;
import com.dbms.model.Employee;
import com.dbms.model.Product;
public class CartdaoImpl implements Cartdao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CartdaoImpl() {
		
	}
	
	public CartdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void saveCart(String username, Long pid) {
		System.out.println(pid);
		String sql="Select price from Product where product_id=?";
		Long price = (Long)jdbcTemplate.queryForObject(sql, new Object[]{pid}, Long.class);
		String sql1="select count(*) from Cart where username=? and pid=?";
		Integer count = (Integer)jdbcTemplate.queryForObject(sql1,new Object[] {username,pid}, Integer.class);
		if(count==0) {
			String sql2="insert into Cart values(?,?,?,?)";
			jdbcTemplate.update(sql2,new Object[] {username,pid,1,price});
		}
		else {
			String sql3="update Cart set qincart=qincart+1 where username=? and pid=?";
			jdbcTemplate.update(sql3,new Object[] {username,pid});
		}
	}
	@Transactional
	public List<Cart> showUserCart(String username){
		String sql="select p.product_id, p.price, p.cap, p.pcksize, p.swpsize, p.color, p.carea, p.name, c.qincart from Product p,Cart c where p.product_id=c.pid and c.username='"+username+"'";
		List <Cart> allcart=jdbcTemplate.query(sql,new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException{
				Cart cart = new Cart();
				cart.setName(rs.getString("name"));
				cart.setPid(rs.getLong("product_id"));
				cart.setMaxq(getMaxQuantity(cart.getPid()));
				cart.setQincart(rs.getLong("qincart"));
				cart.setPrice(rs.getLong("price"));
				cart.setCap(rs.getLong("cap"));
				cart.setPcksize(rs.getLong("pcksize"));
				cart.setColor(rs.getString("color"));
				cart.setCarea(rs.getLong("carea"));
				cart.setSwpsize(rs.getLong("swpsize"));
				return cart;
			}
		});
		return allcart;
	}
	@Transactional
	public void deleteCartEntry(String username, Long pid) {
		String sql="delete from Cart where username=? and pid=?";
		jdbcTemplate.update(sql,new Object[] {username,pid});
	}
	@Transactional
	public Long showPrice(String username) {
		String sql="select sum(qincart*price) from Cart where username=? group by username";
		try{Long price=(Long)jdbcTemplate.queryForObject(sql, new Object[] {username}, Long.class);
		return price;}
		catch(EmptyResultDataAccessException e) {return null;}
	}
	@Transactional
	public Long getMaxQuantity(Long pid) {
		String sql="select qinstock from Product where product_id=?";
		Long quantity=(Long)jdbcTemplate.queryForObject(sql, new Object[] {pid}, Long.class);
		return quantity;
	}
	@Transactional
	public void updateCartEntry(Cart cart) {
		String sql="update Cart set qincart=? where username=? and pid=?";
		jdbcTemplate.update(sql, new Object[] {cart.getQincart(),cart.getUsername(),cart.getPid()});
	}
}
