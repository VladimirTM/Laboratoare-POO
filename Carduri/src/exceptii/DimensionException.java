package exceptii;

public class DimensionException extends RuntimeException {
	public DimensionException() {
		super();
	}

	public DimensionException(String message) {
		super(message);
	}
}