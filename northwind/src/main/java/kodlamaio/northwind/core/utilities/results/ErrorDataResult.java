package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<Type> extends DataResult<Type>{
    public ErrorDataResult(Type data) {
        super(data, false);
    }

    public ErrorDataResult() {
        super(null, false);
    }

    public ErrorDataResult(Type data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(String message) {
        super(null, false, message);
    }
}
