package hrmsDay8Homework.hrmsDay8.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsDay8Homework.hrmsDay8.business.abstracts.JobAdvertisementService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getbyactivestatus")
	public DataResult<List<JobAdvertisement>> getByActiveStatus(boolean isActive){
		return this.jobAdvertisementService.getByActiveStatus(isActive);
	}
	
	@GetMapping("/getbyactivestatusandreleasedate")
	public DataResult<List<JobAdvertisement>> getByActiveStatusAndReleaseDate(boolean isActive, String releaseDate){
		return this.jobAdvertisementService.getByActiveStatusAndReleaseDate(isActive, releaseDate);
	}
	
	@GetMapping("/getbyactivestatusandcompanyname")
	public DataResult<List<JobAdvertisement>> getByActiveStatusAndCompanyName(boolean isActive, String companyName){
		return this.jobAdvertisementService.getByActiveStatusAndCompanyName(isActive, companyName);
	}
	

}
