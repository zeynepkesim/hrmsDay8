package hrmsDay8Homework.hrmsDay8.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsDay8Homework.hrmsDay8.business.abstracts.EmployerService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(Employer employer) {
		return this.employerService.add(employer);
	}
	
	
}
