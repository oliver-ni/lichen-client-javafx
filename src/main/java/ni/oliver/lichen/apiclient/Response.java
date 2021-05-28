package ni.oliver.lichen.apiclient;

/**
 * Represents an API response.
 */
public class Response {
    private String status;
    private Result value;

    /**
     * Get the status.
     * 
     * @return the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get the value.
     * 
     * @return the value.
     */
    public Result getValue() {
        return value;
    }
}
