package practice.second;

import java.util.Comparator;

public class CompAsc implements Comparator<FilmKey> {
    public int compare(FilmKey f1, FilmKey f2) {
        if (f1.getId() < f2.getId()) return -1;
        else if (f1.getId() == f2.getId()) return 0;
        else return 1;
    }
}
