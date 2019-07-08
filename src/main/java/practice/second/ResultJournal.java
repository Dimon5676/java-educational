package practice.second;

import practice.first.CompBudAsc;

import java.util.*;

public class ResultJournal {
    private final String JOURNAL = "Журнал: %s, количество фильмов: %d";

    private String name;
    private Map<FilmKey, Integer> journal;

    public ResultJournal() {
        name = "";
        journal = new TreeMap<FilmKey, Integer>();
    }

    public ResultJournal(String name) {
        this.name = name;
        journal = new TreeMap<FilmKey, Integer>();
    }

    public ResultJournal(String name, Comparator<FilmKey> comparator) {
        this.name = name;
        this.journal = new TreeMap<FilmKey, Integer>(comparator);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<FilmKey, Integer> getJournal() {
        return journal;
    }

    public void setJournal(Map<FilmKey, Integer> journal) {
        this.journal = journal;
    }

    public String toString() {
        return String.format(JOURNAL, name, journal.size());
    }

    public boolean addFilm(FilmKey filmKey, int rank) {
        if (journal.containsKey(filmKey)) return false;
        journal.put(filmKey, rank);
        return true;
    }

    public boolean delFilm(FilmKey filmKey) {
        if (!journal.containsKey(filmKey)) return false;
        journal.remove(filmKey);
        return true;
    }

    public boolean delFilm(int id) {
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        Iterator<Map.Entry<FilmKey, Integer>> iter = pairs.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Map.Entry<FilmKey, Integer> pair = iter.next();
            if (pair.getKey().getId() == id) {
                iter.remove();
                i++;
            }
        }
        return i != 0;
    }

    public boolean updateFilm(FilmKey filmKey, int rank) {
        if (!journal.containsKey(filmKey)) return false;
        journal.put(filmKey, rank);
        return true;
    }

    public int size() {
        return journal.size();
    }

    public ResultJournal selectFilmData(int id) {
        ResultJournal resultJournal = new ResultJournal(String.format("Результаты фестевалей для данного фильма id: %d", id));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            if (pair.getKey().getId() == id) resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal selectFestData(String fest) {
        ResultJournal resultJournal = new ResultJournal(String.format("Фильмы учавствовшие в данном фестивале: %s", fest));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            if (pair.getKey().getFest().equals(fest)) resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal selectNominationData(String nomination) {
        ResultJournal resultJournal = new ResultJournal(String.format("Фильмы учавствовшие в данной номинации: %s", nomination));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            if (pair.getKey().getNomination().equals(nomination)) resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal selectBetweenRank(int a, int b) {
        ResultJournal resultJournal = new ResultJournal(String.format("Фильмы занявшие места с %d по %d", a, b));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            if (pair.getValue() >= a && pair.getValue() <= b) resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal sortAcsId() {
        ResultJournal resultJournal = new ResultJournal(String.format("Журнал %s отсортированный по возрастанию id", name), new CompBudAsc());
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal sortAcsRank() {
        ResultJournal resultJournal = new ResultJournal(String.format("Журнал %s отсортированный по возрастанию места", name), new CompAscId(journal));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public ResultJournal sortDescRank() {
        ResultJournal resultJournal = new ResultJournal(String.format("Журнал %s отсортированный по убыванию места", name), new CompDescId(journal));
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            resultJournal.addFilm(pair.getKey(), pair.getValue());
        }
        return resultJournal;
    }

    public void display() {
        System.out.println(this);
        Set<Map.Entry<FilmKey, Integer>> pairs = journal.entrySet();
        for (Map.Entry<FilmKey, Integer> pair:pairs) {
            System.out.print(String.format("%s \tместо: %d\n", pair.getKey(), pair.getValue()));
        }
    }
}
