package practice.first;

public class Film implements Comparable<Film> {
    //Константы
    private final static String FILM = "Фильм: id:%d, название: %s, год: %s, бюджет: %.2f";
    //Поля
    private int id;
    private String name;
    private String year;
    private double budget;

    //Конструкторы
    public Film() {
        this.id = 0;
        this.name = "";
        this.year = "";
        this.budget = 0;
    }

    public Film(int id, String name, String year, double budget) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.budget = budget;
    }

    public Film(Film film) {
        this.id = film.id;
        this.name = film.name;
        this.year = film.year;
        this.budget = film.budget;
    }

    //Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String toString() {
        return String.format(FILM, id, name, year, budget);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Film film = (Film)obj;
        return this.id == film.id;
    }

    public int hashCode() {
        return 3 * Integer.valueOf(id).hashCode();
    }

    public int compareTo(Film film) {
        if (id < film.id) return -1;
        else if (id == film.id) return 0;
        else return 1;
    }
}
