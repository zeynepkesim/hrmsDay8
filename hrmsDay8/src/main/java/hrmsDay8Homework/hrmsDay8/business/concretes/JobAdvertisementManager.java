package hrmsDay8Homework.hrmsDay8.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsDay8Homework.hrmsDay8.business.abstracts.JobAdvertisementService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessDataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessResult;
import hrmsDay8Homework.hrmsDay8.dataAccess.abstracts.JobAdvertisementDao;
import hrmsDay8Homework.hrmsDay8.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "job advertisement listed successfully");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement added successfully");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveStatus(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatus(isActive), "active job advertisements listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveStatusAndReleaseDate(boolean isActive, String releaseDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatusAndReleaseDate(isActive, releaseDate), "active job advertisements listed according to release date");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveStatusAndCompanyName(boolean isActive, String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatusAndCompanyName(isActive, companyName), "active job advertisements listed according to company name");
	}

	
}
