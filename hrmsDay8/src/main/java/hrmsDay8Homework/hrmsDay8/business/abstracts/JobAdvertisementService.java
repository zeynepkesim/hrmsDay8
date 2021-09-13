package hrmsDay8Homework.hrmsDay8.business.abstracts;

import java.util.List;

import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByActiveStatus(boolean isActive);
	
	DataResult<List<JobAdvertisement>> getByActiveStatusAndReleaseDate(boolean isActive, String releaseDate);
	
	DataResult<List<JobAdvertisement>> getByActiveStatusAndCompanyName(boolean isActive, String companyName);

}
