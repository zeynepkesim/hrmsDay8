package hrmsDay8Homework.hrmsDay8.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsDay8Homework.hrmsDay8.business.abstracts.CityService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessDataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessResult;
import hrmsDay8Homework.hrmsDay8.dataAccess.abstracts.CityDao;
import hrmsDay8Homework.hrmsDay8.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "city listed successfully");
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("city added successfully");
	}

	
}
