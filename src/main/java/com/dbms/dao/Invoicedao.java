package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Cart;
import com.dbms.model.Invoice;

public interface Invoicedao {
	public List<Invoice> fillInvoiceentry(String username, Long amount, List<Cart> centry, Integer invid);
	public Integer fillInvoice(String username, Long amount);
	public List<Invoice> showInvoice(Integer invid);
	public List<Invoice> showInvoiceEntry(Integer invid);
	public List<Invoice> showallInvoice();
	public String findUser(Integer invid);
	public List<Invoice> showInvoiceEntryuser(String username);
}
