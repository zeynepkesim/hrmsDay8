package hrmsDay8Homework.hrmsDay8.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsDay8Homework.hrmsDay8.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
