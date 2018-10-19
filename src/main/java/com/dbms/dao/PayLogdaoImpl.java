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

import com.dbms.model.Employee;
import com.dbms.model.PayLog;

public class PayLogdaoImpl implements PayLogdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PayLogdaoImpl() {
		
	}
	
	public PayLogdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void updateELog(PayLog paylog) {
		String sql="insert into PayLog(emp_id,amount,ptype,dop) values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {paylog.getEmp_id(),paylog.getAmount(),"Employee", paylog.getDop()});
		
	}
	@Transactional
	public void updateMLog(PayLog paylog) {
		String sql="insert into PayLog(man_id,amount,ptype,dop) values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {paylog.getMan_id(),paylog.getAmount(),"Manufacturer", paylog.getDop()});
		
	}
	@Transactional
	public List<PayLog> displog(){
		
		String sql="select * from PayLog";
		List<PayLog> allpay = jdbcTemplate.query(sql, new RowMapper<PayLog>(){
		@Override
		public PayLog mapRow(ResultSet rs, int rowNum) throws SQLException{
			PayLog paylog=new PayLog();
			paylog.setPayid(rs.getLong("payid"));
			paylog.setEmp_id(rs.getLong("emp_id"));
			paylog.setMan_id(rs.getLong("man_id"));
			paylog.setAmount(rs.getLong("amount"));
			paylog.setDop(rs.getDate("dop"));
			paylog.setPtype(rs.getString("ptype"));
			return paylog;
		}
		});
		return allpay;
	}

}
