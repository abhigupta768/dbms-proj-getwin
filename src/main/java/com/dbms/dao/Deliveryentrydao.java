package com.dbms.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.dbms.model.Deliveryentry;
public interface Deliveryentrydao {
	@Autowired
	public void saveDentry(Deliveryentry deliveryentry, Integer invid);
	public List<Deliveryentry> showDentry(String dvalue);
	public void updateDentry(Deliveryentry deliveryentry, String dvalue);
}
