package hrmsDay8Homework.hrmsDay8.core.utilities.results;

public class SuccessResult extends Result {
	
	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String message) {
		super(true, message);
	}
	
}
