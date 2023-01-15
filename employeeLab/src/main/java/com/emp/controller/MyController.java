package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.employee.Employee;
import com.emp.repository.EmpRepository;
import com.emp.service.ServiceEmp;

@Controller
public class MyController {

	@Autowired
	private ServiceEmp serviceEmp;

	@GetMapping(value = "/addemp")
	public String addEmp(Model model) {
		//creating model attribute to bind data
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "addemp";
	}

	// hendler for process
	@GetMapping(value = "/process")
	public String processForm(@ModelAttribute("employee") Employee employee) {
		serviceEmp.saveEmp(employee);

		return "redirect:/getallproducts";
	}

	@GetMapping(value = "/getallproducts")
	public String getAllproducts(Model model) {
		model.addAttribute("showemp", serviceEmp.getAllProducts());
		return ("showemp");

	}
	
	@GetMapping("/update_form/{id}")
	public String updateEmp(@PathVariable("id")int id, Model model) {
		Employee employee = this.serviceEmp.getEmp(id);
		model.addAttribute("employee",employee);
		
		
		return "update_form";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") int id) {
		//call delte employee mthod
		this.serviceEmp.deleteEmployeeId(id);
		return "redirect:/getallproducts";
	}
}
