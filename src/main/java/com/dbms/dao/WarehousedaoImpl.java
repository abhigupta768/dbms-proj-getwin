package com.dbms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Warehouse;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
public class WarehousedaoImpl implements Warehousedao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public WarehousedaoImpl() {
		
	}
	
	public WarehousedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public List<Warehouse> showWarehouses(){
		String sql="select * from Warehouse";
		List<Warehouse> allware =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Warehouse>(Warehouse.class));
		return allware;
	}
	@Transactional
	public void delete(Long wid) {
		String sql = "DELETE FROM Warehouse WHERE wid=?";
		jdbcTemplate.update(sql,wid);
	}
	@Transactional
	public Warehouse getWarehouse(Long wid) {
		String sql = "SELECT * FROM Warehouse WHERE wid='"+wid+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Warehouse>() {
		
		public Warehouse extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setState(rs.getString("state"));
				warehouse.setWid(rs.getLong("wid"));
				warehouse.setAddress(rs.getString("address"));
				warehouse.setCity(rs.getString("city"));
				warehouse.setPincode(rs.getLong("pincode"));
				return warehouse;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateWarehouse(Warehouse warehouse) {
		String sql="INSERT INTO Warehouse(state,city,pincode,address) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {warehouse.getState(),warehouse.getCity(),warehouse.getPincode(),warehouse.getAddress()});
		
	}
	@Transactional
	public void warehouseUpdate(Warehouse warehouse) {
		String sql="Update Warehouse set state=?,city=?,pincode=?,address=? where wid=?";
		jdbcTemplate.update(sql,new Object[] {warehouse.getState(),warehouse.getCity(),warehouse.getPincode(),warehouse.getAddress(),warehouse.getWid()});
	}
	
}
