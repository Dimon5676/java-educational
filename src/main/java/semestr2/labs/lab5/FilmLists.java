package semestr2.labs.lab5;

public interface FilmLists {

    void setName(String name);
    String getName();
    Film getFilmById(int id);
    boolean addFilm(Film film);
    boolean removeFilmById(int id);
    void display();
    double getAverBud();
    FilmLists getGreaterAver();
    FilmLists between(double a, double b);
}
