package ni.oliver.lichen.apiclient;

import java.util.List;

/**
 * Represents an analysis result from the API.
 */
public class Result {
    private double score;
    private List<List<List<Integer>>> matches;

    /**
     * Get the score.
     * 
     * @return
     */
    public double getScore() {
        return score;
    }

    /**
     * Get the matches.
     * 
     * @return
     */
    public List<List<List<Integer>>> getMatches() {
        return matches;
    }
}
