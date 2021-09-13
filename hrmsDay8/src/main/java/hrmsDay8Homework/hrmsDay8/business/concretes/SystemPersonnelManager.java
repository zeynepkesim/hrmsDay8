package hrmsDay8Homework.hrmsDay8.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsDay8Homework.hrmsDay8.business.abstracts.SystemPersonnelService;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessDataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.SuccessResult;
import hrmsDay8Homework.hrmsDay8.dataAccess.abstracts.SystemPersonnelDao;
import hrmsDay8Homework.hrmsDay8.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{
	
	private SystemPersonnelDao systemPersonnelDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(), "system personnel listed successfully");
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult("system personnel added");
	}

	
}
