package net.codejava.controller;

import java.io.IOException;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.grocery.beans.*;
import com.grocery.dao.*;

@Controller
public class HomeController {

	@Autowired
	public cust cust;
	
	@Autowired
	public prod prod;
	
	@Autowired
	public ord ord;
	
	@RequestMapping(value="/")
	public ModelAndView test(Model model) throws IOException{
		return new ModelAndView("home", "login", new customers());
	}
	
	@RequestMapping(value="/register")
	public ModelAndView reg(Model model) throws IOException{
		return new ModelAndView("register", "saveInfo", new customers());
	}
	
	@RequestMapping(value="/store")
	public String store(Model model) throws IOException{
		return "store";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("login") customers cust, BindingResult res, ModelMap model) throws IOException {
		if(res.hasErrors()) {
			return "home";
		}
		else {
			customers r = this.cust.login(cust.getname(), cust.getpass());
			if(r == null) {
				return "error";
			}
			else {
				model.addAttribute("id", r.getId());
				model.addAttribute("name", r.getname());
				model.addAttribute("email", r.getemail());
				model.addAttribute("searchbox", new search());
				return "store";
			}
		}
	}
	
	@RequestMapping(value="/sign", method=RequestMethod.POST)
	public String sign(@ModelAttribute("saveInfo") customers saveInfo, BindingResult res, ModelMap model) throws IOException {
		if(res.hasErrors()) {
			return "register";
		}
		else {
			if(this.cust.register(saveInfo) == 0) {
				model.addAttribute("login", new customers());
				return "home";
			}
			else
				return "error";
		}
	}
	
	@RequestMapping(value="/getresults", method=RequestMethod.POST)
	public String search(@ModelAttribute("searchbox") search searchbox, BindingResult res, ModelMap model) throws IOException {
		if(res.hasErrors() || searchbox.gettext().trim() == "") {
			model.addAttribute("id", searchbox.getid());
			model.addAttribute("name", searchbox.getname());
			model.addAttribute("searchbox", new search());
			return "store";
		}
		else {
			model.addAttribute("prods", this.prod.searchproduct(searchbox.gettext()));
			model.addAttribute("searchbox", searchbox);
			model.addAttribute("id", searchbox.getid());
			model.addAttribute("name", searchbox.getname());
			return "store";
		}
	}
	
	@RequestMapping(value="/addItem")
	public String addItem(@RequestParam("id") Integer id, @RequestParam("pid") Integer pid, @RequestParam("name") String name, @RequestParam("txt") String txt, ModelMap model) throws IOException {
		orders o = new orders();
		o.setcustomer_id(id);
		o.setproduct_id(pid);
		int j = this.ord.placeOrder(o);
		if(j == 0) {
			search se = new search();
			se.setid(id);
			se.setname(name);
			se.settext(txt);
			model.addAttribute("searchbox", se);
			model.addAttribute("name", name);
			model.addAttribute("id", id);
			return "store";
		}
		else {
			model.addAttribute("login", new customers());
			return "home";
		}
	}
	
	@RequestMapping(value="/processcart")
	public String process(@RequestParam("id") Integer id, ModelMap model) throws IOException {
		int j = id;
		customers cust = this.cust.getcustomer(j);
		List<orders> orders = this.ord.getOrders(j);
		List<products> prods = new ArrayList<products>();
		for(int i = 0; i < orders.size(); i++) {
			products e = this.prod.getproductByID(orders.get(i).getproduct_id());
			if(e != null)
				prods.add(e);
		}
		if(cust != null) {
			model.addAttribute("prods", prods);
			model.addAttribute("name", cust.getname());
			model.addAttribute("id", cust.getId());
		}
		return "cart";
	}
	
	@RequestMapping(value="/removeitem")
	public String removeItem(@RequestParam("id") Integer id, @RequestParam("pid") Integer pid, ModelMap model) throws IOException {
		if(this.ord.deleteOrder(id, pid) == 0) {
			return process(id, model);
		}
		else {
			model.addAttribute("login", new customers());
			return "home";	
		}
	}
}