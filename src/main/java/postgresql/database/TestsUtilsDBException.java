package postgresql.database;

/**
 * @author Dmitriy Bulynenkov (yxryab@gmail.com)
 *         04.05.16.
 */

public class TestsUtilsDBException extends RuntimeException {
    public TestsUtilsDBException() {
    }

    public TestsUtilsDBException(String message) {
        super(message);
    }

    public TestsUtilsDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestsUtilsDBException(Throwable cause) {
        super(cause);
    }

}
