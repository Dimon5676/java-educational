package practice.first;

import java.util.*;

public class CinemaList {
    //Поля
    private final String CINEMA = "Кинотеатр: %s, кол-во фильмов: %d";

    private String name;
    private List<Film> films;
    private int numberOfFilms;
    //Конструкторы
    public CinemaList() {
        name = "";
        films = new ArrayList<Film>();
        numberOfFilms = 0;
    }

    public CinemaList(String name) {
        this.name = name;
        films = new ArrayList<Film>();
        numberOfFilms = 0;
    }

    public CinemaList(String name, List list) {
        this.name = name;
        this.films = new ArrayList<Film>(list);
        numberOfFilms = list.size();
    }

    //Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public List<Film> getFilms() {
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
    public CinemaList getAboveAver() {
        double aver = getAverBud();
        CinemaList aboveAver = new CinemaList(String.format("%s: Фильмы, с бюджетом выще среднего - %.2f", name,aver));
        for (Film film:films) {
            if (film.getBudget() > aver) aboveAver.addFilm(film);
        }
        return aboveAver;
    }

    //Возвращение фильмов с бюжетом в интервале от a до b
    public CinemaList getBetween(double a, double b) {
        CinemaList between = new CinemaList(String.format("%s: Фильмы, с бюджетом от %.2f до %.2f", name, a, b));

        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getBudget() > a && film.getBudget() < b) between.addFilm(film);
        }
        return between;
    }

    //Сортировки
    public CinemaList sort() {
        CinemaList sorted = new CinemaList(name, films);
        Collections.sort(sorted.films);
        return sorted;
    }

    public CinemaList sort(Comparator<Film> comp) {
        CinemaList sorted = new CinemaList(name, films);
        Collections.sort(sorted.films, comp);
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
    public CinemaList nameContains(String str) {
        CinemaList nameContains = new CinemaList(String.format("Список фильмов, содержащих в названии: %s", str));
        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getName().contains(str)) nameContains.addFilm(film);
        }
        return nameContains;
    }

    //Случайная выборка из n фильмов
    public CinemaList random(int n) {
        if (n > numberOfFilms) n = numberOfFilms;
        CinemaList random = new CinemaList(String.format("Случайная выборка из %d фильмов", n));
        while (random.getNumberOfFilms() != n) {
            random.addFilm(films.get((int)(Math.random()*numberOfFilms)));
        }
        return random;
    }

    //Выброка из n фильмов с наибольшим бюджетом
    public CinemaList best(int n) {
        if (n > numberOfFilms) n = numberOfFilms;
        CinemaList best = new CinemaList(String.format("Выборка из %d фильмов с наибтльшим бюджетом", n));
        List<Film> temp = new ArrayList<Film>(films);
        Collections.sort(temp, new CompBudDesc());
        int i = 0;
        for (Film film:temp) {
            best.addFilm(film);
            i++;
            if (i == n) break;
        }
        return best;
    }

    //Выброка из n фильмов с наименьшим бюджетом
    public CinemaList worst(int n) {
        if (n > numberOfFilms) n = numberOfFilms;
        CinemaList best = new CinemaList(String.format("Выборка из %d фильмов с наименьшим бюджетом", n));
        List<Film> temp = new ArrayList<Film>(films);
        Collections.sort(temp, new CompBudAsc());
        int i = 0;
        for (Film film:temp) {
            best.addFilm(film);
            i++;
            if (i == n) break;
        }
        return best;
    }

    //Увеличение бюджета n фильмам с наибольшим бюджетом на value
    public void addToBest(int n, double value) {
        if (n > numberOfFilms) n = numberOfFilms;
        CinemaList temp = best(n);
        for (Film film:temp.getFilms()) {
            film.setBudget(film.getBudget() + value);
        }
    }

    //Удаление фильмов, название которых превышает n или не содержит str
    public void deleteLongStringOrContains(int n, String str) {
        Iterator<Film> iter = films.iterator();
        while (iter.hasNext()) {
            Film film = iter.next();
            if (film.getName().length() > n || !(film.getName().contains(str))) {
                iter.remove();
                numberOfFilms--;
            }
        }
    }
}