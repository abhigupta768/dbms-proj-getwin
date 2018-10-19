package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Product;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
public class ProductdaoImpl implements Productdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductdaoImpl() {
		
	}
	@Transactional
	public List<Product> showProducts(){
		String sql="select * from Product";
		List<Product> allpro =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return allpro;
	}
	public ProductdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void delete(Long product_id) {
		String sql = "DELETE FROM Product WHERE product_id=?";
		jdbcTemplate.update(sql,product_id);
	}
	@Transactional
	public Product getProduct(Long product_id) {
		String sql = "SELECT * FROM Product WHERE product_id='"+product_id+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Product>() {
		
		public Product extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Product product = new Product();
				product.setName(rs.getString("name"));
				//product.setPassword(rs.getString("password"));
				product.setMid(rs.getLong("mid"));
				product.setProduct_id(rs.getLong("product_id"));
				product.setType(rs.getString("type"));
				product.setHsncode(rs.getString("hsncode"));
				product.setQinstock(rs.getLong("qinstock"));
				product.setPrice(rs.getLong("price"));
				product.setCap(rs.getLong("cap"));
				product.setPcksize(rs.getLong("pcksize"));
				product.setColor(rs.getString("color"));
				product.setCarea(rs.getLong("carea"));
				product.setSwpsize(rs.getLong("swpsize"));
				return product;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateProduct(Product product) {
		String sql="INSERT INTO Product(mid, wid, type, hsncode, qinstock, price, cap, pcksize, swpsize, color, carea, name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {product.getMid(),product.getWid(), product.getType(),product.getHsncode(),product.getQinstock(),product.getPrice(), product.getCap(),product.getPcksize(),product.getSwpsize(),product.getColor(),product.getCarea(),product.getName()});
		
	}
		
	public void proUpdate(Product product) {
		String sql="Update Product set mid=?, wid=?, type=?,hsncode=?,qinstock=?,price=?,cap=?,pcksize=?,swpsize=?,color=?,carea=?,name=? where product_id=?";
		jdbcTemplate.update(sql,new Object[] {product.getMid(),product.getWid(),product.getType(),product.getHsncode(),product.getQinstock(),product.getPrice(), product.getCap(),product.getPcksize(),product.getSwpsize(),product.getColor(),product.getCarea(),product.getName(),product.getProduct_id()});
	}
	
}
