package semestr2.labs.lab5;

public class FilmList implements FilmLists{
    private Film el;
    private FilmList next;
    private final String FORM_STR = "Список: %s, число фильмов: %d";

    public FilmList() {
        this.el = null;
        this.next = null;
    }

    public FilmList(Film film) {
        this.el = film;
        this.next = null;
    }

    public FilmList(int id, String name, String year, double budget) {
        this.el = new Film(id, name, year, budget);
        this.next = null;
    }

    public int getNum() {
        int num = 0;
        FilmList el = next;

        while (el != null) {
            num++;
            el = el.next;
        }
        return num;
    }

    public String getName() {
        return el.getName();
    }

    public void setName(String name) {
        el.setName(name);
    }

    public Film getFilmById(int id) {
        if (next == null) return null;
        FilmList filmList = next;
        while (filmList != null) {
            if (filmList.el.getId() == id) return filmList.el;
            filmList = filmList.next;
        }
        return null;
    }

    public String toString() {
        return String.format(FORM_STR, el.getName(), getNum());
    }

    public boolean addFilm(Film film) {
        if (getFilmById(film.getId()) != null) return false;
        FilmList filmList = new FilmList(film);
        FilmList head = this;
        if (next == null) {
            next = filmList;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = filmList;
        }
        return true;
    }

    public boolean removeFilmById(int id) {
        FilmList filmList = this;
        while (filmList.next != null) {
            if (filmList.next.el.getId() == id) {
                filmList.next = filmList.next.next;
                return true;
            }
            filmList = filmList.next;
        }
        return false;
    }

    public void display() {
        System.out.println(el.getName());
        System.out.printf("%5s%11s%11s%18s\n", "Номер","Название","Год","Бюджет");
        FilmList filmList = next;
        while (filmList != null) {
            System.out.printf("%-7d %-15s %-14s %.2f\n", filmList.el.getId(), filmList.el.getName(), filmList.el.getYear(), filmList.el.getBudget());
            filmList = filmList.next;
        }
    }

    public double getAverBud() {
        double summ = 0;
        FilmList fl = next;
        while (fl != null) {
            summ += fl.el.getBudget();
            fl = fl.next;
        }
        return summ/getNum();
    }

    public FilmList getGreaterAver() {
        double aver = getAverBud();
        FilmList head = new FilmList(0, "Бюджет выше среднего", "", 0);
        FilmList filmList = next;
        while (filmList != null) {
            if (filmList.el.getBudget() > aver) head.addFilm(filmList.el);
            filmList = filmList.next;
        }
        return head;
    }

    public FilmList between(double a, double b) {
        double aver = getAverBud();
        FilmList head = new FilmList(0, String.format("В интервале от %.2f до %.2f", a, b), "", 0);
        FilmList filmList = next;
        while (filmList != null) {
            if (filmList.el.getBudget() > a && filmList.el.getBudget() < b) head.addFilm(filmList.el);
            filmList = filmList.next;
        }
        return head;
    }
}
