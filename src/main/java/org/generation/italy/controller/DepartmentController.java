package org.generation.italy.controller;

import org.generation.italy.model.Department;
import org.generation.italy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DepartmentController {

	@Autowired // ogni volta che crea un'istanza controller deva anche iniettarle da repo
	private DepartmentRepository repo;

	@GetMapping
	public String departmentList(Model model) {
		model.addAttribute("list", repo.findAll(Sort.by("name")));
		return "departments";
	}
	
	@GetMapping("/department/{department_id}")
	public String departmentDegrees(Model model, @PathVariable Integer department_id) {
		
		Department d = repo.getById(department_id);
		model.addAttribute("department", d);
		model.addAttribute("degrees", d.getDegrees());
		return "detail";
	}
	
}
