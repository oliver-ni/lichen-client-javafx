package ni.oliver.lichen.apiclient;

import java.util.List;

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

    public String getLang() {
        return lang;
    }

    public List<String> getFiles() {
        return files;
    }
}
