package hrmsDay8Homework.hrmsDay8.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int jobAdvertisementId;
	
	@ManyToOne()
	@JoinColumn(name="position_name")
	JobPosition jobPosition;
	
	@NotNull
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@NotNull
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@NotNull
	@Column(name="release_date")
	private String releaseDate;
	
	@Column(name="application_deadline")
	private String applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name="city_name")
	City city;
	
	@ManyToOne()
	@JoinColumn(name="company_name")
	Employer employer;
	
	
}
