package hrmsDay8Homework.hrmsDay8.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsDay8Homework.hrmsDay8.business.abstracts.JobSeekerService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.ErrorResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessDataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessResult;
import hrmsDay8Homework.hrmsDay8.dataAccess.abstracts.JobSeekerDao;
import hrmsDay8Homework.hrmsDay8.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "jobseeker added successfully");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(acceptance(jobSeeker)) {
			return new ErrorResult("jobseeker cannot be added, not all mandatory fields have been filled!");
		}else if(checkRegisteredEmailAndIdentityNumber(jobSeeker)) {
			return new ErrorResult("jobseeker could not be added, the email address and identity number you have entered are already registered!");
		}else
			this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("jobseeker added successfully");
	}
	
	public boolean acceptance(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName().isBlank() || jobSeeker.getLastName().isBlank() || jobSeeker.getIdentityNumber().isBlank()
		   || jobSeeker.getBirthYear().isBlank() || jobSeeker.getEmail().isBlank() || jobSeeker.getPassword().isBlank()
		   || jobSeeker.getPasswordVerification().isBlank()) {
			return true;
		} else
			return false;
	}
	
	public boolean checkRegisteredEmailAndIdentityNumber(JobSeeker jobSeeker) {
		List<JobSeeker> jobSeekers = this.jobSeekerDao.findAll();
		for (JobSeeker jobSeekerIndex : jobSeekers) {
			if ( jobSeeker.getEmail() == jobSeekerIndex.getEmail() || jobSeeker.getIdentityNumber() == jobSeekerIndex.getIdentityNumber()) {
				return true;
			}
		}
		return false;
	}

}
