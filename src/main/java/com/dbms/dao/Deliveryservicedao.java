package com.dbms.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dbms.model.Deliveryservice;

public interface Deliveryservicedao {
	@Autowired
	public void delete(Long sid);
	public Deliveryservice getDservice(Long sid);
	public void saveOrUpdateDservice(Deliveryservice deliveryservice);
	public List<Deliveryservice> showDservice();
	public void dsUpdate(Deliveryservice deliveryservice);
}
