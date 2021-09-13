package hrmsDay8Homework.hrmsDay8.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsDay8Homework.hrmsDay8.business.abstracts.EmployerService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.ErrorResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessDataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessResult;
import hrmsDay8Homework.hrmsDay8.dataAccess.abstracts.EmployerDao;
import hrmsDay8Homework.hrmsDay8.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "employer listed successfully");
	}

	@Override
	public Result add(Employer employer) {
		if(!acceptance(employer)) {
			return new ErrorResult("employer cannot be added, not all mandatory fields have been filled!");
		}else if(checkRegisteredEmail(employer) == true) {
			return new ErrorResult("the email address you have entered is already registered!");
		}else
			this.employerDao.save(employer);
		return new SuccessResult("employer added successfully");
	}
	
	public boolean acceptance(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getWebSite().isBlank() || employer.getEmail().isBlank()
		   || employer.getPhoneNumber().isBlank() || employer.getPassword().isBlank() || employer.getPasswordVerification().isBlank()) {
			return false;
		} else
			return true;
	}
	
	public boolean checkRegisteredEmail(Employer employer) {
		List<Employer> employers = this.employerDao.findAll();
		for (Employer employerIndex : employers) {
			if(employer.getEmail() == employerIndex.getEmail()) {
				return false;
			}
		}
		return true;
	}
	
	
}
