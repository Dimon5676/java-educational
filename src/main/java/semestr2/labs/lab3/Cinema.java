package semestr2.labs.lab3;

public class Cinema {
    private static final String CINEMA_FORMAT_STRING = "Кинотеатр: %s, кол-во фильмов: %d\n";
    private static final int MIN_NUM = 5;

    private String name;
    private Film[] filmList;
    private int numFilms;

    public Cinema() {
        name = "";
        filmList = new Film[MIN_NUM];
        numFilms = 0;
    }

    public Cinema(String name, Film[] filmList, int numFilms) {
        this.name = name;
        this.filmList = filmList;
        this.numFilms = numFilms;
    }

    public String getName() {
        return name;
    }

    public int getNumFilms() {
        return numFilms;
    }

    public Film getFilmById(int id) {
        return filmList[id];
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addFilm(Film film) {
        if (film.getId() > filmList.length) return false;
        if (filmList[film.getId()] != null) return false;
        filmList[film.getId()] = film;
        numFilms++;
        return true;
    }

    public void removeFilmById(int id) {
        filmList[id] = null;
        numFilms--;
    }

    public double averBud() {
        double sum = 0;
        for (Film film : filmList) {
            if (film == null) continue;
            sum += film.getBudget();
        }
        return sum / (filmList.length - numFilms);
    }

    public Film[] getGreaterAver() {
        Film[] films;
        int num = 0;
        for (Film film : filmList) {
            if (film.getBudget() > averBud()) num++;
        }
        films = new Film[num];
        int i = 0;
        for (Film film : filmList) {
            if (film.getBudget() > averBud()) films[i++] = film;
        }
        return films;
    }

    public Film[] getFilmsByInterval(double from, double to) {
        Film[] films;
        int num = 0;
        for (Film film : filmList) {
            if (film.getBudget() >= from && film.getBudget() <= to) num++;
        }
        films = new Film[num];
        int i = 0;
        for (Film film : filmList) {
            if (film.getBudget() >= from && film.getBudget() <= to) films[i++] = film;
        }
        return films;
    }

    public void displayFilmList() {
        for (Film film : filmList) {
            if (film == null) continue;
            System.out.println(film);
        }
    }

    public String toString() {
        return String.format(CINEMA_FORMAT_STRING, name, numFilms);
    }

    public Film[] sortedByYear() {
        Film[] films = filmList.clone();
        boolean flag;
        for (int m = films.length - 1; m > 0; m--) {
            flag = true;
            for (int j = 0; j < m; j++)
                if (films[j].getYear().compareTo(films[j + 1].getYear()) > 0) {
                    Film b = films[j];
                    films[j] = films[j + 1];
                    films[j + 1] = b;
                    flag = false;
                }
            if (flag) break;
        }
        return films;
    }
}
