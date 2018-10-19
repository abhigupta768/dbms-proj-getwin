package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Manufacturer;

public class ManufacturerdaoImpl implements Manufacturerdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ManufacturerdaoImpl() {
		
	}
	
	public ManufacturerdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void delete(String name) {
		String sql = "DELETE FROM Manufacturer WHERE name=?";
		jdbcTemplate.update(sql,name);
	}
	@Transactional
	public Manufacturer getManufacturer(String name) {
		String sql = "SELECT * FROM Manufacturer WHERE name='"+name+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Manufacturer>() {
		
		public Manufacturer extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setName(rs.getString("name"));
				//manufacturer.setPassword(rs.getString("password"));
				manufacturer.setAddress(rs.getString("address"));
				manufacturer.setState(rs.getString("state"));
				manufacturer.setPin(rs.getLong("pincode"));
				manufacturer.setCity(rs.getString("city"));
				manufacturer.setWebsite(rs.getString("website"));
				manufacturer.setEmail(rs.getString("email"));
				manufacturer.setPhno(rs.getLong("phone_no"));
				return manufacturer;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateManufacturer(Manufacturer manufacturer) {
		String sql="INSERT INTO Manufacturer(name, address,website,city, state, pincode, email, phone_no) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {manufacturer.getName(),manufacturer.getAddress(),manufacturer.getWebsite(), manufacturer.getCity(),manufacturer.getState(),manufacturer.getPin(),manufacturer.getEmail(),manufacturer.getPhno()});
		
	}
	@Transactional	
	public List<Manufacturer> showManufacturer(){
		String sql="select * from Manufacturer";
		List <Manufacturer> allman=jdbcTemplate.query(sql,new RowMapper<Manufacturer>() {
			@Override
			public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException{
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setName(rs.getString("name"));
				manufacturer.setMid(rs.getLong("manufacturer_id"));
				manufacturer.setAddress(rs.getString("address"));
				manufacturer.setState(rs.getString("state"));
				manufacturer.setPin(rs.getLong("pincode"));
				manufacturer.setCity(rs.getString("city"));
				manufacturer.setWebsite(rs.getString("website"));
				manufacturer.setEmail(rs.getString("email"));
				manufacturer.setPhno(rs.getLong("phone_no"));
				return manufacturer;
			}
		});
		return allman;
	}
	@Transactional
	public void manUpdate(Manufacturer manufacturer) {
		String sql="update Manufacturer set address=?,website=?,city=?,state=?,pincode=?,email=?,phone_no=? where name=?";
		jdbcTemplate.update(sql, new Object[] {manufacturer.getAddress(),manufacturer.getWebsite(),manufacturer.getCity(),manufacturer.getState(),manufacturer.getPin(),manufacturer.getEmail(),manufacturer.getPhno(),manufacturer.getName()});
		
	}
}
