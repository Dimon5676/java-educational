package semestr2.labs.lab4;

public class Film {
    private static final String FILM_FORMAT_STRING = "id фильма:%d, название:%s, год выпуска:%s, бюджет:%.2f\n";

    private int id;
    private String name;
    private String year;
    private double budget;

    public Film() {
        id = 0;
        name = "";
        year = "";
        budget = 0;
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

    public String toString() {
        return String.format(FILM_FORMAT_STRING, id, name, year, budget);
    }

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
}
