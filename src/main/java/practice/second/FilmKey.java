package practice.second;

public class FilmKey implements Comparable<FilmKey> {
    private final String FILM = "id фильма: %d \tкинофестиваль: %s \tноминация: %s";

    private int id;
    private String fest;
    private String nomination;

    public FilmKey() {
        id = 0;
        fest = "";
        nomination = "";
    }

    public FilmKey(int id, String fest, String nomination) {
        this.id = id;
        this.fest = fest;
        this.nomination = nomination;
    }

    public FilmKey(FilmKey filmKey) {
        this.id = filmKey.id;
        this.fest = filmKey.fest;
        this.nomination = filmKey.nomination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFest() {
        return fest;
    }

    public void setFest(String fest) {
        this.fest = fest;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String toString() {
        return String.format(FILM, id, fest, nomination);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        FilmKey filmKey = (FilmKey)obj;
        return (id == filmKey.id) && (fest.equals(filmKey.fest)) && (nomination.equals(filmKey.nomination));
    }

    public int hashCode() {
        return 3 * Integer.valueOf(id).hashCode() + 7 * fest.hashCode() + 11 * nomination.hashCode();
    }

    public int compareTo(FilmKey filmKey) {
        if (id < filmKey.id) return -1;
        if (id > filmKey.id) return 1;

        if (fest.compareTo(filmKey.fest) < 0) return -1;
        if (fest.compareTo(filmKey.fest) > 0) return 1;

        if (nomination.compareTo(filmKey.nomination) < 0) return -1;
        if (nomination.compareTo(filmKey.nomination) > 0) return 1;
        return 0;
    }
}
