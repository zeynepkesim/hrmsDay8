package hrmsDay8Homework.hrmsDay8.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrmsDay8Homework.hrmsDay8.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	@Query("From JobAdvertisement where isActive = true")
	List<JobAdvertisement> getByActiveStatus(boolean isActive);

	@Query("From JobAdvertisement where isActive = true and jobAdvertisement.releaseDate =: releaseDate")
	List<JobAdvertisement> getByActiveStatusAndReleaseDate(boolean isActive, String releaseDate);
	
	@Query("From JobAdvertisement where isActive = true and employer.companyName =: companyName")
	List<JobAdvertisement> getByActiveStatusAndCompanyName(boolean isActive, String companyName);
}
