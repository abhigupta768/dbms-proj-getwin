package com.dbms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Cart;
import com.dbms.model.Invoice;
import com.dbms.model.Product;
public class InvoicedaoImpl implements Invoicedao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public InvoicedaoImpl() {
		
	}
	
	public InvoicedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public Integer fillInvoice(String username, Long amount) {
		String sql ="Insert into Invoice(username,dog,amount) values(?,?,?)";
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		jdbcTemplate.update(sql,new Object[] {username,date,amount});
		String sql1="select invid from Invoice where username='"+username+"' order by invid desc limit 1";
		Integer invid=(Integer)jdbcTemplate.queryForObject(sql1, new Object[] {}, Integer.class);
		return invid;
	}
	@Transactional
	public List<Invoice> fillInvoiceentry(String username, Long amount, List<Cart> centry, Integer invid) {
		for(Cart c:centry) {
			String sql2="Insert into InvoiceEntry values(?,?,?,?)";
			jdbcTemplate.update(sql2, new Object[] {invid,c.getPid(),c.getQincart(),c.getPrice()});
			String sql3="Delete from Cart where username=? and pid=?";
			jdbcTemplate.update(sql3,new Object[] {username,c.getPid()});
			String sql4="update Product set qinstock=qinstock-? where product_id=?";
			jdbcTemplate.update(sql4,new Object[] {c.getQincart(),c.getPid()});
		}
		List<Invoice> allinvent=showInvoiceEntry(invid);
		return allinvent;
	}
	@Transactional
	public List<Invoice> showInvoice(Integer invid){
		String sql="select * from Invoice where invid='"+invid+"'";
		List<Invoice> allinv =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
		return allinv;
	}
	@Transactional
	public List<Invoice> showInvoiceEntry(Integer invid){
		String sql="select * from InvoiceEntry where invid='"+invid+"'";
		List<Invoice> allinvent =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
		return allinvent;
	}
	@Transactional
	public List<Invoice> showInvoiceEntryuser(String username){
		String sql="select * from Invoice where username='"+username+"'";
		List<Invoice> allinv =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
		return allinv;
	}
	@Transactional
	public List<Invoice> showallInvoice(){
		String sql="select * from Invoice";
		List<Invoice> allinv =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Invoice>(Invoice.class));
		return allinv;
	}
	@Transactional
	public String findUser(Integer invid) {
		String sql="select username from Invoice where invid=?";
		String username=(String)jdbcTemplate.queryForObject(sql, new Object[] {invid}, String.class);
		return username;
	}
}
