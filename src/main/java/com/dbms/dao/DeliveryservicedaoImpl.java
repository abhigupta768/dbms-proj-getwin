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

import com.dbms.model.Deliveryservice;

public class DeliveryservicedaoImpl implements Deliveryservicedao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DeliveryservicedaoImpl() {
		
	}
	public DeliveryservicedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void delete(Long sid) {
		String sql = "DELETE FROM Deliveryservice WHERE sid=?";
		jdbcTemplate.update(sql,sid);
	}
	@Transactional
	public Deliveryservice getDservice(Long sid) {
		String sql = "SELECT * FROM Deliveryservice WHERE sid='"+sid+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Deliveryservice>() {
		
		public Deliveryservice extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Deliveryservice deliveryservice = new Deliveryservice();
				deliveryservice.setName(rs.getString("name"));
				//deliveryservice.setPassword(rs.getString("password"));
				deliveryservice.setPhno(rs.getLong("phno"));
				deliveryservice.setSid(rs.getLong("sid"));
				return deliveryservice;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateDservice(Deliveryservice deliveryservice) {
		String sql="INSERT INTO Deliveryservice(name,phno) VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {deliveryservice.getName(),deliveryservice.getPhno()});
		
	}
	@Transactional	
	public List<Deliveryservice> showDservice(){
		String sql="select * from Deliveryservice";
		List <Deliveryservice> allds=jdbcTemplate.query(sql,new RowMapper<Deliveryservice>() {
			@Override
			public Deliveryservice mapRow(ResultSet rs, int rowNum) throws SQLException{
				Deliveryservice deliveryservice = new Deliveryservice();
				deliveryservice.setName(rs.getString("name"));
				//deliveryservice.setPassword(rs.getString("password"));
				deliveryservice.setPhno(rs.getLong("phno"));
				deliveryservice.setSid(rs.getLong("sid"));
				return deliveryservice;
			}
		});
		return allds;
	}
	@Transactional
	public void dsUpdate(Deliveryservice deliveryservice) {
		String sql="update Deliveryservice set name=?,phno=? where sid=?";
		jdbcTemplate.update(sql, new Object[] {deliveryservice.getName(),deliveryservice.getPhno(),deliveryservice.getSid()});
		
	}
}
