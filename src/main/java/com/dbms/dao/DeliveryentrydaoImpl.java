package com.dbms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Deliveryentry;

public class DeliveryentrydaoImpl implements Deliveryentrydao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DeliveryentrydaoImpl() {
		
	}
	@Transactional
	public void saveDentry(Deliveryentry deliveryentry, Integer invid) {
		String sql="insert into Deliveryentry(invid,address,city,state,pincode,phno,isdelivered) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {invid,deliveryentry.getAddress(),deliveryentry.getCity(),deliveryentry.getState(),deliveryentry.getPincode(),deliveryentry.getPhno(),"No"});
	}
	@Transactional
	public List<Deliveryentry> showDentry(String dvalue){
		String sql="select * from Deliveryentry where isdelivered='"+dvalue+"'";
		List<Deliveryentry> allde =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Deliveryentry>(Deliveryentry.class));
		return allde;
	}
	@Transactional
	public void updateDentry(Deliveryentry deliveryentry, String dvalue) {
		String sql="update Deliveryentry set dsid=?, dod=?, isdelivered=? where invid=?";
		jdbcTemplate.update(sql,new Object[] {deliveryentry.getDsid(),deliveryentry.getDod(),dvalue,deliveryentry.getInvid()});
	}
}
