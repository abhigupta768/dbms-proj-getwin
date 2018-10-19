package com.dbms.dao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.dbms.model.Warehouse;
public interface Warehousedao {
	@Autowired
	public void delete(Long wid);
	public Warehouse getWarehouse(Long wid);
	public void saveOrUpdateWarehouse(Warehouse warehouse);
	public List<Warehouse> showWarehouses();
	public void warehouseUpdate(Warehouse warehouse);
}
