package semestr2.labs.lab3;

public class Demo{
    private static void displayArr(Film[] arr) {
        if (arr == null) return;
        for (Film film:arr)
            System.out.println(film);
    }

    @SuppressWarnings("Duplicates") //Условия лабораторной работы требуют дублировать код для наглядной демонстрации
    public static void main (String[ ] args) {
        String[] filmNames = {"Непрощенный", "Анон", "Такси 5", "Мег: Монстр глубины", "Реинкарнация", "Мстители: Война бесконечности и дополнительные материалы", "Атлантида"};
        String[] filmYears = {"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "3020"};
        Cinema cinema1 = new Cinema("Чайка", new Film[5], 0);
        Cinema cinema2 = new Cinema();
        cinema2.setName("ТопФилм");

        for (int i = 0; i < 5; i++){
            cinema1.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5));
        }

        for (int i = 0; i < 5; i++){
            cinema2.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], ((Math.random()*5)+1)));
        }

        System.out.println ("Сформированы следующие кинотеатры:");
        System.out.printf ("%s,\n%s\n\n", cinema1, cinema2);

        if (!cinema1.addFilm(new Film(0, "Test", "2000", 1.3))) {
            System.out.printf ("В кинотеатр %s добавить фильм 0 не удалось:\n",
                    cinema1.getName());
            System.out.println(" нарушена уникальность ключа.");
        }

        if (!cinema2.addFilm(new Film(7, "Test", "2000", 1.3))) {
            System.out.printf ("В кинотеатр %s добавить фильм 7 не удалось:\n",
                    cinema2.getName());
            System.out.println(" превышен лимит.");
        }
        System.out.println();

        cinema1.displayFilmList();
        System.out.printf("Средний бюджет: %.2f\n", cinema1.averBud());
        System.out.println("Фильмы, у которых бюджет выше среднего:");
        displayArr(cinema1.getGreaterAver());
        System.out.println("Фильмы, у которых бюджет в диапазоне [3.2,4.2]:");
        displayArr(cinema1.getFilmsByInterval(3.2, 4.2));

        cinema1.removeFilmById(2);

        System.out.printf("Состав фильмов %s после удаления одного:\n",
                cinema1.getName());
        cinema1.displayFilmList();
        System.out.println();

        cinema2.displayFilmList();
        System.out.printf("Средний бюджет: %.2f\n", cinema2.averBud());
        System.out.println("Фильмы, у которых бюджет выше среднего:");
        displayArr(cinema2.getGreaterAver());
        System.out.println("Фильмы, у которых бюджет в диапазоне [3.2,4.2]:");
        displayArr(cinema2.getFilmsByInterval(3.2f,4.2f));

        cinema2.removeFilmById(2);

        System.out.printf ("Состав фильмов %s после удаления одного:\n",
                cinema2.getName());
        cinema2.displayFilmList();
        System.out.println();

        System.out.println("Проверка наличия студентов:");
        int n = 3;
        Film f1 = cinema1.getFilmById(n);
        System.out.printf ("В кинотеатре %s:\n", cinema1.getName());
        if (f1 == null) System.out.printf("Нет фильма с номером %d\n",n);
        else System.out.println(f1);
        n=2;
        f1 = cinema1.getFilmById(n);
        if (f1 == null) System.out.printf("Нет фильма с номером %d\n",n);
        else System.out.println(f1);
        n=4;
        f1 = cinema2.getFilmById(n);
        System.out.printf ("В кинотеатре %s:\n", cinema2.getName());
        if (f1 == null) System.out.printf ("Нет фильма с номером %d\n",n);
        else System.out.println(f1);
    }
}