package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.dbms.model.Employee;
import com.dbms.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UserdaoImpl implements Userdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void saveOrUpdate(User user) {
		 String sql = "INSERT INTO Userdata(username, password, role) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(), "ROLE_USER"});
		 saveOrUpdateCustomer(user);
		 //System.out.println("EROOR");
		 System.out.println("EROOR");
	}
	@Transactional
	public void delete(String username) {
		String sql = "DELETE FROM Userdata WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	@Transactional
	public User getUser(String username) {
		String sql = "SELECT * FROM Userdata WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateCustomer(User user) {
		String sql="INSERT INTO Customer(name, address, city, state, pincode, phone_no, email, username) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {user.getName(),user.getAddress(),user.getCity(),user.getState(),user.getPin(),user.getPhno(),user.getEmail(),user.getUsername()});
		
	}
	@Transactional
	public User getCustomer(String username) {
		String sql = "select name,address,city,state,pincode,phone_no,email,password from Customer,Userdata u WHERE u.username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
//				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMpassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setState(rs.getString("state"));
				user.setPhno(rs.getLong("phone_no"));
				user.setPin(rs.getLong("pincode"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public String findRole(String username) {
		String sql="select role from Userdata where username=?";
		String role=(String)jdbcTemplate.queryForObject(sql, new Object[] {username}, String.class);
		return role;
	}
	@Transactional
	public void userUpdate(User user) {
		String sql="update Customer set name=?,address=?,city=?,state=?,pincode=?,phone_no=?,email=? where username=?";
		jdbcTemplate.update(sql,new Object[] {user.getName(), user.getAddress(), user.getCity(), user.getState(), user.getPin(), user.getPhno(), user.getEmail(), user.getUsername()});
		String sql1="update Userdata set password=? where username=?";
		jdbcTemplate.update(sql1, new Object[] {user.getPassword(),user.getUsername()});
		System.out.println("EROOR");
	}
	@Transactional
	public List<User> showUser(String username){
		String sql="select * from Customer where username='"+username+"'";
		List <User> alluser=jdbcTemplate.query(sql,new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User usr = new User();
				usr.setUsername(rs.getString("username"));
				usr.setName(rs.getString("name"));
				usr.setAddress(rs.getString("address"));
				usr.setState(rs.getString("state"));
				usr.setCity(rs.getString("city"));
				usr.setPin(rs.getLong("pincode"));
				usr.setPhno(rs.getLong("phone_no"));
				usr.setEmail(rs.getString("email"));
				return usr;
			}
		});
		return alluser;
	}
}