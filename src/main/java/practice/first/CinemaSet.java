package practice.first;

import java.util.*;

public class CinemaSet {
    //Поля
    private final String CINEMA = "Кинотеатр: %s, кол-во фильмов: %d";

    private String name;
    private Set<Film> films;
    private int numberOfFilms;
    //Конструкторы
    public CinemaSet() {
        name = "";
        films = new TreeSet<Film>();
        numberOfFilms = 0;
    }

    public CinemaSet(String name) {
        this.name = name;
        films = new TreeSet<Film>();
        numberOfFilms = 0;
    }

    public CinemaSet(String name, Comparator comparator) {
        this.name = name;
        films = new TreeSet<Film>(comparator);
        numberOfFilms = 0;
    }

    public CinemaSet(String name, Set set) {
        this.name = name;
        this.films = new TreeSet<Film>(set);
        numberOfFilms = set.size();
    }

    //Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public int getNumberOfFilms() {
        return numberOfFilms;
    }

    public Film getFilmById(int id) {
        for (Film film:films) {
            if (film.getId() == id) return film;
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Добавление фильма в кинотеатр
    public boolean addFilm(Film film) {
        if (film == null) return false;
        if (getFilmById(film.getId()) != null) return false;
        if (films.add(film)) {
            numberOfFilms++;
            return true;
        } else {
            return false;
        }
    }

    //Удаление фильма по id
    public boolean removeFilmById(int id) {
        if (films.remove(new Film(id, "", "", 0))) {
            numberOfFilms--;
            return true;
        } else {
            return false;
        }
    }

    //Возвращение среднего бюджета всех фильмов в кинотеатре
    public double getAverBud() {
        if (numberOfFilms == 0) return 0;
        double aver = 0;
        for (Film film:films) {
            aver += film.getBudget();
        }
        return aver/numberOfFilms;
    }

    //Возвращение фильмов с бюджетом выще среднего
    public CinemaSet getAboveAver() {
        double aver = getAverBud();
        CinemaSet aboveAver = new CinemaSet(String.format("%s: Фильмы, с бюджетом выще среднего - %.2f", name,aver));
        for (Film film:films) {
            if (film.getBudget() > aver) aboveAver.addFilm(film);
        }
        return aboveAver;
    }

    //Возвращение фильмов с бюжетом в интервале от a до b
    public CinemaSet getBetween(double a, double b) {
        CinemaSet between = new CinemaSet(String.format("%s: Фильмы, с бюджетом от %.2f до %.2f", name, a, b));

        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getBudget() > a && film.getBudget() < b) between.addFilm(film);
        }
        return between;
    }

    //Сортировки
    //Сортировка по возрастанию бюджета
    public CinemaSet sortAsc() {
        CinemaSet sorted = new CinemaSet("Фильмы, отсортированные по возрастанию", new CompBudAsc());
        for (Film film:films) {
            sorted.addFilm(film);
        }
        return sorted;
    }
    //Сортировка по убыванию бюджета
    public CinemaSet sortDesc() {
        CinemaSet sorted = new CinemaSet("Фильмы, отсортированные по возрастанию", new CompBudDesc());
        for (Film film:films) {
            sorted.addFilm(film);
        }
        return sorted;
    }
    //Сортировка по убыванию бюджета и убыванию годв
    public CinemaSet sortDescTwo() {
        CinemaSet sorted = new CinemaSet("Фильмы, отсортированные по возрастанию", new CompDescTwo());
        for (Film film:films) {
            sorted.addFilm(film);
        }
        return sorted;
    }

    //Вывод списка фильмов кинотетра в терминал
    public void display() {
        System.out.println(this);
        int i = 1;
        for (Film film:films){
            System.out.print(String.format("%3d %s\n", i++, film));
        }
    }

    public String toString() {
        return String.format(CINEMA, name, numberOfFilms);
    }

    //Обновление id фильма
    public boolean update(int id, int newId) {
        if (getFilmById(newId) != null) return false;
        if (getFilmById(id) == null) return false;
        getFilmById(id).setId(newId);
        return true;
    }

    //Удаление фильмов с бюджетом в интервале от a до b
    public void removeBetween(double a, double b) {
        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getBudget() > a && film.getBudget() < b) {
                iter.remove();
                numberOfFilms--;
            }
        }
    }

    //Возвращение списка фильмов, содержащих в названии строку str
    public CinemaSet nameContains(String str) {
        CinemaSet nameContains = new CinemaSet(String.format("Список фильмов, содержащих в названии: %s", str));
        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getName().contains(str)) nameContains.addFilm(film);
        }
        return nameContains;
    }

    public CinemaSet intersection(CinemaSet second) {
        CinemaSet intersection = new CinemaSet(String.format("Фильмы, котороые есть в кинотеатрах %s и %s", name, second.name));
        for (Film first:films) {
            for (Film sec:second.films) {
                if (first.equals(sec)) intersection.addFilm(first);
            }
        }
        return intersection;
    }

    public CinemaSet join(CinemaSet second) {
        CinemaSet join = new CinemaSet(String.format("Все Фильмы, котороые есть в кинотеатрах %s и %s", name, second.name));
        for (Film film:films) {
            join.addFilm(film);
        }
        for (Film film:second.films) {
            join.addFilm(film);
        }
        return join;
    }

    public CinemaSet substraction(CinemaSet second) {
        CinemaSet sub = new CinemaSet(String.format("Фильмы кинотеатра %s, без фильмов кинотеатра %s", name, second.name));
        CinemaSet inter = intersection(second);
        for (Film film:films) {
            for (Film intersec:inter.films) {
                if (!(film.equals(intersec))) sub.addFilm(film);
            }
        }
        return sub;
    }
}