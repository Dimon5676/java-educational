package practice.first;

public class DemoSet {
    public static void main(String[] args) {
        //Создание 2х кинотеатров
        CinemaSet cinema1 = new CinemaSet("Первый кинотеатр");
        CinemaSet cinema2 = new CinemaSet("Второй кинотеатр");
        //Заполнение кинотеатров фильмами (по 5 в каждый)
        cinema1.addFilm(new Film(1, "Film1", "2000", 3.7));
        cinema1.addFilm(new Film(2, "Some Film2", "1999", 4.5));
        cinema1.addFilm(new Film(3, "Film3", "2002", 1.3));
        cinema1.addFilm(new Film(4, "Some Film", "1991", 6.4));
        cinema1.addFilm(new Film(5, "Some interesting film", "1987", 3.7));

        cinema2.addFilm(new Film(1, "Some Film1", "1841", 3.7));
        cinema2.addFilm(new Film(2, "Film2", "5102", 4.5));
        cinema2.addFilm(new Film(3, "Some Film3", "2007", 1.3));
        cinema2.addFilm(new Film(4, "Film4", "1999", 6.4));
        cinema2.addFilm(new Film(5, "Some Film5", "1987", 3.7));
        //Выборка данных
        //Вывод с естественным порядком сортировки
        System.out.println("Кинотеатр (c естественным порядком сортировки)");
        cinema1.display();
        System.out.println();
        //Пытаемся вставить фильс с уже существующим id
        System.out.println("Попытка добавить фильм с существующим id");
        System.out.println(cinema1.addFilm(new Film(2, "Some film", "2021", 4.3)));
        System.out.println();
        //Вывод списка фильмов с сортировками
        System.out.println("Кинотеатр (с сортировкой по возрастанию бюджета)");
        cinema1.sortAsc().display();
        System.out.println();
        System.out.println("Кинотеатр (с сортировкой по убыванию бюджета)");
        cinema1.sortDesc().display();
        System.out.println();
        System.out.println("Кинотеатр (с сортировкой по убыванию бюджета и убыванию года)");
        cinema1.getBetween(4.4, 7.31).sortDescTwo().display();
        System.out.println();
        //Удаление фмльма по id
        System.out.println("Удаление фильма с id 1");
        cinema1.removeFilmById(1);
        System.out.println("После удаления фильма с id 1");
        cinema1.display();
        //Вывод фильмов второго кинотеатра
        System.out.println();
        System.out.println("Киноткатр (c естественным порядком сортировки)");
        cinema2.display();
        System.out.println();
        System.out.println("Кинотеатр (c сортировкой по возрастанию бюджета)");
        cinema2.sortAsc().display();
        System.out.println();
        System.out.println("Кинотеатр (с сортировкой по убыванию бюджета)");
        cinema2.sortDesc().display();
        System.out.println();
        System.out.println("Кинотеатр (с сортировкой по убыванию бюджета и убыванию года)");
        cinema2.getBetween(4.3, 7.31).sortDescTwo().display();
        System.out.println();
        //Проверяем есть ли в первом кинотеатре фильм с id 7
        Film film = cinema1.getFilmById(7);
        if (film == null) System.out.println("В кинотетаре нет фильма с id 7");
        else System.out.println(film);
        //Проверяем есть ли в первом кинотеатре фильм с id 3
        film = cinema1.getFilmById(3);
        if (film == null) System.out.println("В кинотетаре нет фильма с id 3");
        else System.out.println(film);
        //Проверяем есть ли во второй кинотеатре фильм с id 7
        film = cinema2.getFilmById(7);
        if (film == null) System.out.println("В кинотетаре нет фильма с id 7");
        else System.out.println(film);
        //Проверяем есть ли во втором кинотеатре фильм с id 3
        film = cinema1.getFilmById(3);
        if (film == null) System.out.println("В кинотетаре нет фильма с id 3");
        else System.out.println(film);
        System.out.println();
        //Вывод фмльмов с бюджетом выше среднего
        System.out.println("Фильмы с бюджетом выше среднего");
        cinema1.getAboveAver().display();
        System.out.println();
        //Обновлене id у фильма с id 2
        System.out.println("Обновлене id у фильма с id 2");
        cinema2.update(2, 7);
        //Вывод фильмов после обновления id
        System.out.println("Вывод фильмов после обновления id");
        cinema2.display();
        System.out.println();
        //Удаление фмльмов с бюджетом от 1.32 до 4.32
        System.out.println("Удаление фмльмов с бюджетом от 1.32 до 4.32");
        cinema2.removeBetween(1.32, 4.32);
        //Вывод после удаления фмльмов с бюджетом от 1.32 до 4.32
        cinema2.display();
        System.out.println();
        //Вывод фильмов, назавние которых содержит "Some"
        System.out.println("Вывод фильмов, назавние которых содержит \"Some\"");
        cinema2.nameContains("Some").display();
        //Дополнительные методы
        //Методы алгебры множеств
        //Объединение
        System.out.println("Объединение");
        cinema1.join(cinema2).display();
        System.out.println();
        //Пересечение
        System.out.println("Пересечение");
        cinema2.intersection(cinema1).display();
        System.out.println();
        //Вычитание
        System.out.println("Вычитание");
        cinema2.substraction(cinema1).display();
        System.out.println();
    }
}
