package com.dbms;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbms.dao.Employeedao;
import com.dbms.dao.Manufacturerdao;
import com.dbms.dao.Productdao;
import com.dbms.dao.Userdao;
import com.dbms.dao.Cartdao;
import com.dbms.dao.Invoicedao;
import com.dbms.dao.Warehousedao;
import com.dbms.dao.PayLogdao;
import com.dbms.dao.Deliveryservicedao;
import com.dbms.dao.Deliveryentrydao;
import com.dbms.model.Employee;
import com.dbms.model.Manufacturer;
import com.dbms.model.Product;
import com.dbms.model.User;
import com.dbms.model.Cart;
import com.dbms.model.Invoice;
import com.dbms.model.Warehouse;
import com.dbms.model.PayLog;
import com.dbms.model.Deliveryservice;
import com.dbms.model.Deliveryentry;
@Controller
public class MainController {

	@Autowired
	public Userdao userdao;
	@Autowired
	public Employeedao employeedao;
	@Autowired
	public Manufacturerdao manufacturerdao;
	@Autowired
	public Productdao productdao;
	@Autowired
	public Cartdao cartdao;
	@Autowired
	public Invoicedao invoicedao;
	@Autowired
	public Warehousedao warehousedao;
	@Autowired
	public PayLogdao paylogdao;
	@Autowired
	public Deliveryservicedao deliveryservicedao;
	@Autowired
	public Deliveryentrydao deliveryentrydao;
	
	@RequestMapping(value = "/")
	public String welcome(Model model) {
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "unsecured page !");
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "home";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "redirect:/";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}
	
	@RequestMapping("/empl")
	public String empl(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "empl";
	}
	
	@RequestMapping("/user")
	public String user(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "user";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);

		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "register";
			}
			if(userdao.getUser(user.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "register";
			}
			userdao.saveOrUpdate(user);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="admin/empregister",method=RequestMethod.GET)
	public String empregister(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "empregister";
	}
	
	@RequestMapping(value="admin/empregister",method=RequestMethod.POST)
	public String empregisterProcess(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "empregister";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "empregister";
			}
			if(employeedao.getEmployeeUser(employee.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "empregister";
			}
			employeedao.saveOrUpdate(employee);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showemployees")
	public String adshowemployees(Model model) {
		List<Employee> allemp=employeedao.showEmployee();
		model.addAttribute("allemp",allemp);
		return "showemployees";
	}
	
	@RequestMapping(value="/admin/showemployees/delete/{username}")
	public String delemp(@PathVariable("username") String username) {
		employeedao.delete(username);
		return "redirect:/admin/showemployees";
	}
	
	@RequestMapping(value="/admin/showemployees/update",method=RequestMethod.GET)
	public String adempupdate(HttpServletRequest request, Model model) {
		String username = request.getParameter("user");
		Employee employee = employeedao.getEmployee(username);
		model.addAttribute("employee", employee);
		model.addAttribute("username", username);
		return "empupdate";
	}
	
	@RequestMapping(value="/admin/showemployees/update",method=RequestMethod.POST)
	public String adempupdateProcess(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "empupdate";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "empupdate";
			}
			System.out.println("bgdf"+employee.getName());
			employeedao.empUpdate(employee);
			return "redirect:/admin/showemployees";
		}
	}
	
	@RequestMapping(value="admin/proregister",method=RequestMethod.GET)
	public String adproregister(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		List<Warehouse> allwar=warehousedao.showWarehouses();
		model.addAttribute("allwar",allwar);
		model.addAttribute("allman",allman);
		return "proregister";
	}
	
	@RequestMapping(value="admin/proregister",method=RequestMethod.POST)
	public String adproregisterProcess(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/proregister";
		}
		else {
			productdao.saveOrUpdateProduct(product);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showproducts")
	public String adshowproducts(Model model, Principal principal) {
		List<Product> allpro=productdao.showProducts();
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		model.addAttribute("allpro",allpro);
		return "showproducts";
	}
	
	@RequestMapping(value="/admin/showproducts/delete/{name}")
	public String addelpro(@PathVariable("name") Long name) {
		productdao.delete(name);
		return "redirect:/admin/showproducts";
	}
	
	@RequestMapping(value="/admin/showproducts/update",method=RequestMethod.GET)
	public String adproupdate(HttpServletRequest request, Model model) {
		Long pid = Long.parseLong(request.getParameter("name"));
		Product product = productdao.getProduct(pid);
		model.addAttribute("product", product);
		model.addAttribute("pid", pid);
		List<Warehouse> allwar=warehousedao.showWarehouses();
		model.addAttribute("allwar",allwar);
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		model.addAttribute("allman",allman);
		return "proupdate";
	}
	
	@RequestMapping(value="/admin/showproducts/update",method=RequestMethod.POST)
	public String adproupdateProcess(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "proupdate";
		}
		else {
			productdao.proUpdate(product);
			return "redirect:/admin/showproducts";
		}
	}
	
	@RequestMapping(value="admin/manregister",method=RequestMethod.GET)
	public String manregister(Model model) {
		
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);

		return "manregister";
	}
	
	@RequestMapping(value="admin/manregister",method=RequestMethod.POST)
	public String manregisterProcess(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "manregister";
		}
		else {
			manufacturerdao.saveOrUpdateManufacturer(manufacturer);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showmanufacturers")
	public String adshowmanufacturers(Model model) {
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		model.addAttribute("allman",allman);
		return "showmanufacturers";
	}
	
	@RequestMapping(value="/admin/showmanufacturers/delete/{name}")
	public String delman(@PathVariable("name") String name) {
		manufacturerdao.delete(name);
		return "redirect:/admin/showmanufacturers";
	}
	
	@RequestMapping(value="/admin/showmanufacturers/update",method=RequestMethod.GET)
	public String admanpupdate(HttpServletRequest request, Model model) {
		String name = request.getParameter("user");
		Manufacturer manufacturer = manufacturerdao.getManufacturer(name);
		model.addAttribute("manufacturer", manufacturer);
		model.addAttribute("name", name);
		return "manupdate";
	}
	
	@RequestMapping(value="/admin/showmanufacturers/update",method=RequestMethod.POST)
	public String admanupdateProcess(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "manupdate";
		}
		else {
			manufacturerdao.manUpdate(manufacturer);
			return "redirect:/admin/showmanufacturers";
		}
	}
	
	@RequestMapping(value="admin/wareregister",method=RequestMethod.GET)
	public String adwareregister(Model model) {
		
		Warehouse warehouse = new Warehouse();
		model.addAttribute("warehouse", warehouse);
		return "wareregister";
	}
	
	@RequestMapping(value="admin/wareregister",method=RequestMethod.POST)
	public String adwareregisterProcess(@Valid @ModelAttribute("warehouse") Warehouse warehouse,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "wareregister";
		}
		else {
			warehousedao.saveOrUpdateWarehouse(warehouse);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showwarehouses")
	public String adshowwarehouses(Model model) {
		List<Warehouse> allware=warehousedao.showWarehouses();
		model.addAttribute("allware",allware);
		return "showwarehouses";
	}
	
	@RequestMapping(value="/admin/showwarehouses/delete/{warehouse}")
	public String delwar(@PathVariable("warehouse") Long warehouse) {
		warehousedao.delete(warehouse);
		return "redirect:/admin/showwarehouses";
	}
	
	@RequestMapping(value="/admin/showwarehouses/update",method=RequestMethod.GET)
	public String adwareupdate(HttpServletRequest request, Model model) {
		Long wid = Long.parseLong(request.getParameter("war"));
		Warehouse warehouse = warehousedao.getWarehouse(wid);
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("wid", wid);
		return "wareupdate";
	}
	
	@RequestMapping(value="/admin/showwarehouses/update",method=RequestMethod.POST)
	public String adempupdateProcess(@Valid @ModelAttribute("warehouse") Warehouse warehouse,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "wareupdate";
		}
		else {
			warehousedao.warehouseUpdate(warehouse);
			return "redirect:/admin/showwarehouses";
		}
	}
	
	@RequestMapping(value="admin/dsregister",method=RequestMethod.GET)
	public String addsregister(Model model) {
		
		Deliveryservice deliveryservice = new Deliveryservice();
		model.addAttribute("deliveryservice", deliveryservice);
		return "dsregister";
	}
	
	@RequestMapping(value="admin/dsregister",method=RequestMethod.POST)
	public String addsregisterProcess(@Valid @ModelAttribute("deliveryservice") Deliveryservice deliveryservice,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "dsregister";
		}
		else {
			deliveryservicedao.saveOrUpdateDservice(deliveryservice);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showdss")
	public String adshowdss(Model model) {
		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "showdss";
	}
	
	@RequestMapping(value="/admin/showdss/delete/{ds}")
	public String delds(@PathVariable("ds") Long ds) {
		deliveryservicedao.delete(ds);
		return "redirect:/admin/showdss";
	}
	
	@RequestMapping(value="/admin/showdss/update",method=RequestMethod.GET)
	public String addsupdate(HttpServletRequest request, Model model) {
		Long sid = Long.parseLong(request.getParameter("ds"));
		Deliveryservice deliveryservice = deliveryservicedao.getDservice(sid);
		model.addAttribute("deliveryservice", deliveryservice);
		model.addAttribute("sid", sid);
		return "dsupdate";
	}
	
	@RequestMapping(value="/admin/showdss/update",method=RequestMethod.POST)
	public String addsupdateProcess(@Valid @ModelAttribute("deliveryservice") Deliveryservice deliveryservice,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "dsupdate";
		}
		else {
			deliveryservicedao.dsUpdate(deliveryservice);
			return "redirect:/admin/showdss";
		}
	}
	
	@RequestMapping(value="admin/payemp",method=RequestMethod.GET)
	public String emppay(Model model) {
		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Employee> allemp=employeedao.showEmployee();
		model.addAttribute("allemp",allemp);
		return "payemp";
	}
	
	@RequestMapping(value="admin/payemp",method=RequestMethod.POST)
	public String emppayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/payemp";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "redirect:/admin/payemp";
			}
			paylogdao.updateELog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/payman",method=RequestMethod.GET)
	public String manpay(HttpServletRequest request, Model model) {
		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		model.addAttribute("allman",allman);

		return "payman";
	}
	
	@RequestMapping(value="admin/payman",method=RequestMethod.POST)
	public String manpayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/payman";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "redirect:/admin/payman";
			}
			paylogdao.updateMLog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showlog")
	public String showpayLog(Model model) {
		
		List<PayLog> allpay = paylogdao.displog();
		model.addAttribute("allpay",allpay);
		
		return "showlog";
		
	}
	
	@RequestMapping(value="admin/showodn")
	public String showodn(Model model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Deliveryentry> allde=deliveryentrydao.showDentry("No");
		model.addAttribute("allde",allde);
		return "showporders";
	}
	
	@RequestMapping(value="admin/showodn/setds",method=RequestMethod.GET)
	public String adsetds(HttpServletRequest request, Model model) {
		
		Deliveryentry deliveryentry = new Deliveryentry();
		model.addAttribute("deliveryentry", deliveryentry);
		Long invid = Long.parseLong(request.getParameter("invid"));
		model.addAttribute("invid", invid);
		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "setds";
	}
	
	@RequestMapping(value="admin/showodn/setds",method=RequestMethod.POST)
	public String adsetdsProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/showds/setds";
		}
		else {
			deliveryentrydao.updateDentry(deliveryentry,"Yes");
			return "redirect:/admin/showodn";
		}
	}
	
	@RequestMapping(value="admin/showody")
	public String showody(Model model, HttpServletRequest request) {
		List<Deliveryentry> allde=deliveryentrydao.showDentry("Yes");
		model.addAttribute("allde",allde);
		return "showcorders";
	}
	
	@RequestMapping(value="admin/showinvoice")
	public String adshowinv(Model model) {
		List <Invoice> allinv=invoicedao.showallInvoice();
		model.addAttribute("allinv",allinv);
		return "showadinvoice";
	}
	
	@RequestMapping(value="admin/showinvoice/invoice")
	public String adshowpinv(Model model, HttpServletRequest request) {
		Integer invid=Integer.parseInt(request.getParameter("id"));
		List<Invoice> allinv = invoicedao.showInvoice(invid);
		String username=invoicedao.findUser(invid);
		List<User> allusr=userdao.showUser(username);
		List<Invoice> allinvent= invoicedao.showInvoiceEntry(invid);
		model.addAttribute("allinv",allinv);
		model.addAttribute("allusr",allusr);
		model.addAttribute("allinvent",allinvent);
		return "showinvoice";
	}
	
	@RequestMapping(value="empl/proregister",method=RequestMethod.GET)
	public String proregister(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		List<Warehouse> allwar=warehousedao.showWarehouses();
		model.addAttribute("allman",allman);
		model.addAttribute("allwar",allwar);
		return "proregister";
	}
	
	@RequestMapping(value="empl/proregister",method=RequestMethod.POST)
	public String proregisterProcess(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "proregister";
		}
		else {
			productdao.saveOrUpdateProduct(product);
			return "redirect:/empl";
		}
	}
	
	@RequestMapping(value="empl/showproducts")
	public String showproducts(Model model) {
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "showproducts";
	}
	
	@RequestMapping(value="/empl/showproducts/delete/{name}")
	public String empdelpro(@PathVariable("name") Long name) {
		productdao.delete(name);
		return "redirect:/empl/showproducts";
	}
	
	@RequestMapping(value="/empl/showproducts/update",method=RequestMethod.GET)
	public String empproupdate(HttpServletRequest request, Model model) {
		Long pid = Long.parseLong(request.getParameter("name"));
		Product product = productdao.getProduct(pid);
		model.addAttribute("product", product);
		model.addAttribute("pid", pid);
		List<Warehouse> allwar=warehousedao.showWarehouses();
		model.addAttribute("allwar",allwar);
		List<Manufacturer> allman=manufacturerdao.showManufacturer();
		model.addAttribute("allman",allman);
		return "proupdate";
	}
	
	@RequestMapping(value="/empl/showproducts/update",method=RequestMethod.POST)
	public String empproupdateProcess(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "proupdate";
		}
		else {
			productdao.proUpdate(product);
			return "redirect:/empl/showproducts";
		}
	}
	
	@RequestMapping(value="empl/showody")
	public String empshowody(Model model, HttpServletRequest request) {
		List<Deliveryentry> allde=deliveryentrydao.showDentry("Yes");
		model.addAttribute("allde",allde);
		return "showcorders";
	}
	
	@RequestMapping(value="empl/showodn")
	public String empshowodn(Model model, HttpServletRequest request) {
		List<Deliveryentry> allde=deliveryentrydao.showDentry("No");
		model.addAttribute("allde",allde);
		return "showporders";
	}
	
	@RequestMapping(value="empl/showodn/setds",method=RequestMethod.GET)
	public String empsetds(HttpServletRequest request, Model model) {
		
		Deliveryentry deliveryentry = new Deliveryentry();
		model.addAttribute("deliveryentry", deliveryentry);
		Long invid = Long.parseLong(request.getParameter("invid"));
		model.addAttribute("invid", invid);
		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "setds";
	}
	
	@RequestMapping(value="empl/showodn/setds",method=RequestMethod.POST)
	public String empsetdsProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "redirect:/empl/showodn/setds";
		}
		else {
			deliveryentrydao.updateDentry(deliveryentry,"Yes");
			return "redirect:/empl/showodn";
		}
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.GET)
	public String userupdate(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user = userdao.getCustomer(username);
		model.addAttribute("user", user);
		model.addAttribute("username", username);
		return "userupdate";
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.POST)
	public String userupdateProcess(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "userupdate";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "userupdate";
			}
//			System.out.println("bgdf"+employee.getName());
			userdao.userUpdate(user);
			return "redirect:/user";
		}
	}
	
	@RequestMapping(value="/user/showuser")
	public String shuser(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		List<User> allusr=userdao.showUser(username);
		model.addAttribute("allusr",allusr);
		return "userdetails";
	}
	
	@RequestMapping(value="/user/products")
	public String checker(Model model,Principal principal) {
		String user = principal.getName();
		model.addAttribute("user",user);
		model.addAttribute("product","product");
		return "product";
	}
	
	@RequestMapping(value="/user/showinvoice")
	public String usrshowinv(Model model,Principal principal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		List<Invoice> allinv=invoicedao.showInvoiceEntryuser(username);
		model.addAttribute("allinv",allinv);
		return "showusrinvoice";
	}
	
	@RequestMapping(value="user/showinvoice/invoice")
	public String usrshowpinv(Model model, HttpServletRequest request) {
		Integer invid=Integer.parseInt(request.getParameter("id"));
		List<Invoice> allinv = invoicedao.showInvoice(invid);
		String username=invoicedao.findUser(invid);
		List<User> allusr=userdao.showUser(username);
		List<Invoice> allinvent= invoicedao.showInvoiceEntry(invid);
		model.addAttribute("allinv",allinv);
		model.addAttribute("allusr",allusr);
		model.addAttribute("allinvent",allinvent);
		return "showinvoice";
	}
	
	@RequestMapping(value="/user/cart")
	public String addcart(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.saveCart(username,pid);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/user/showcart")
	public String showcart(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println("showcart");
		List<Cart> allcart = cartdao.showUserCart(username);
		Long price = cartdao.showPrice(username);
		System.out.println("showcartprice");
		Integer csize=allcart.size();
		model.addAttribute("allcart",allcart);
		model.addAttribute("csize",csize);
		model.addAttribute("price",price);
		return "showcart";
	}
	
	@RequestMapping(value="/user/showcart/delete")
	public String delcartentry(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.deleteCartEntry(username, pid);
		List<Cart> allcart = cartdao.showUserCart(username);
		model.addAttribute("allcart",allcart);
		return "redirect:/user/showcart";
	}
	
	@RequestMapping(value="/user/showcart/update",method=RequestMethod.GET)
	public String usercartupdate(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		Long maxq=cartdao.getMaxQuantity(pid);
		Cart cart=new Cart();
		model.addAttribute("cart", cart);
		model.addAttribute("username", username);
		model.addAttribute("pid", pid);
		model.addAttribute("maxq", maxq);
		System.out.println("ljkfm");
		return "cartupdate";
	}
	
	@RequestMapping(value="/user/showcart/update",method=RequestMethod.POST)
	public String usercartupdateProcess(@Valid @ModelAttribute("cart") Cart cart,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "cartupdate";
		}
		else {
			if(cart.getQincart()>cart.getMaxq() || cart.getQincart()<1) {
				model.addAttribute("error","please alter quantity");
				return "cartupdate";
			}
			cartdao.updateCartEntry(cart);
			return "redirect:/user/showcart";
		}
	}
	
	@RequestMapping(value="/user/showcart/checkout",method=RequestMethod.GET)
	public String usercartcheckout(HttpServletRequest request, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Deliveryentry deliveryentry=new Deliveryentry();
		model.addAttribute("deliveryentry",deliveryentry);
		model.addAttribute("username",username);
		System.out.println("ljkfm");
		return "checkout";
	}
	
	@RequestMapping(value="/user/showcart/checkout",method=RequestMethod.POST)
	public String usercartupdateProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println("45");
			return "checkout";
		}
		else {
			String username=deliveryentry.getUsername();
			List<Cart> centry = cartdao.showUserCart(username);
			for(Cart c: centry) {
				if(c.getQincart()>cartdao.getMaxQuantity(c.getPid())){
					return "redirect:/user/showcart";
				}
			}
			Long amount=cartdao.showPrice(username);
			Integer invid=invoicedao.fillInvoice(username, amount);
			deliveryentrydao.saveDentry(deliveryentry, invid);
			List<Invoice> allinvent=invoicedao.fillInvoiceentry(username,amount,centry,invid);
			List<Invoice> allinv = invoicedao.showInvoice(invid);
			List<User> allusr=userdao.showUser(username);
			model.addAttribute("allusr",allusr);
			model.addAttribute("allinvent",allinvent);
			model.addAttribute("allinv",allinv);
			return "showinvoice";
		}
	}
	
//	@RequestMapping(value="/user/showcart/invoice")
//	public String showinv(HttpServletRequest request, Model model) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username=authentication.getName();
//		Long amount=cartdao.showPrice(username);
//		List<Cart> centry = cartdao.showUserCart(username);
//		List<Invoice> allinvent=invoicedao.fillInvoice(username, amount,centry);
//		List<Invoice> allinv = invoicedao.showInvoice();
//		model.addAttribute("allinv",allinv);
//		model.addAttribute("allinvent",allinvent);
//		return "showinvoice";
//	}
	
}
