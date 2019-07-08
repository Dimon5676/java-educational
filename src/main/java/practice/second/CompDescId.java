package practice.second;

import java.util.Comparator;
import java.util.Map;

public class CompDescId implements Comparator<FilmKey> {

    Map<FilmKey, Integer> journal;

    public CompDescId(Map<FilmKey, Integer> map) {
        this.journal = map;
    }

    public int compare(FilmKey filmKey1, FilmKey filmKey2) {
        int rank1 = journal.get(filmKey1);
        int rank2 = journal.get(filmKey2);
        if (rank1 < rank2) return 1;
        if (rank1 > rank2) return -1;
        return 0;
    }
}
