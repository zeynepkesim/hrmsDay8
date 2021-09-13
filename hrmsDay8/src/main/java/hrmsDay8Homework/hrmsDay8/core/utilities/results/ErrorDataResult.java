package hrmsDay8Homework.hrmsDay8.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
		
	}
	
	public ErrorDataResult(T data) {
		super(data, false);
		
	}
	
}
