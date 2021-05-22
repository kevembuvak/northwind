package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<Type> extends DataResult<Type>{
    public SuccessDataResult(Type data) {
        super(data, true);
    }

    public SuccessDataResult() {
        super(null, true);
    }

    public SuccessDataResult(Type data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(String message) {
        super(null, true, message);
    }
}
