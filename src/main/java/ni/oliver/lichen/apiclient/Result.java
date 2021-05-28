package ni.oliver.lichen.apiclient;

import java.util.List;

public class Result {
    static interface Entry extends List<Integer> {
        default public int getFromLine() {
            return get(0);
        }

        default public int getToLine() {
            return get(1);
        }
    }

    static interface Match extends List<Entry> {
    }

    private double score;
    private List<Match> matches;

    public double getScore() {
        return score;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
