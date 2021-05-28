package ni.oliver.lichen.apiclient;

import java.util.List;

public class Result {
    private double score;
    private List<List<List<Integer>>> matches;

    public double getScore() {
        return score;
    }

    public List<List<List<Integer>>> getMatches() {
        return matches;
    }
}
