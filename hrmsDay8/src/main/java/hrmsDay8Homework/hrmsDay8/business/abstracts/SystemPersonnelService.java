package hrmsDay8Homework.hrmsDay8.business.abstracts;

import java.util.List;

import hrmsDay8Homework.hrmsDay8.core.utilities.results.DataResult;
import hrmsDay8Homework.hrmsDay8.core.utilities.results.Result;
import hrmsDay8Homework.hrmsDay8.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	
	DataResult<List<SystemPersonnel>> getAll();
	Result add(SystemPersonnel systemPersonnel);

}
