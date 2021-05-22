package kodlamaio.northwind.core.utilities.results;

public class DataResult<Type> extends Result{
    private Type data;

    public DataResult(Type data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(Type data ,boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public Type getData() {
        return this.data;
    }
}
