package ni.oliver.lichen.apiclient;

import java.util.List;

/**
 * Represents an analysis request for the API.
 */
public class Request {
    private String lang;
    private List<String> files;

    /**
     * Constructs a new request for a given language and list of files.
     * 
     * @param lang  the language.
     * @param files the list of files.
     */
    public Request(String lang, List<String> files) {
        this.lang = lang;
        this.files = files;
    }

    /**
     * Get the language.
     * 
     * @return the language.
     */
    public String getLang() {
        return lang;
    }

    /**
     * Get the files.
     * 
     * @return the files.
     */
    public List<String> getFiles() {
        return files;
    }
}
