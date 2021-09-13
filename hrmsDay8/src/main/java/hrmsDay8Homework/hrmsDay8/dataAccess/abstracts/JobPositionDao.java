package hrmsDay8Homework.hrmsDay8.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsDay8Homework.hrmsDay8.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

}
