package semestr2.labs.lab5;

public class Demo {

    public static void setListStatus (FilmLists list, String status){
        list.setName(list.getName()+" " + status);
    }
    @SuppressWarnings("Duplicates")
    public static void main (String[ ] args){
        FilmLists fls1 = new FilmList(0, "Список 1", "", 0);
        FilmLists fls2 = new Cinema("Список2", new Film[5], 0);

        String[] filmNames = {"Непрощенный", "Анон", "Такси 5", "Реинкарнация", "Атлантида"};
        String[] filmYears = {"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "3020"};

        for (int i = 0; i < 5; i++) {
            fls1.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5));
        }

        for (int i = 0; i < 5; i++) {
            fls2.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5));
        }

        System.out.println ("Сформированы следующие списки:");
        System.out.printf ("%s,\n%s\n\n", fls1, fls2);

        if (!fls1.addFilm(new Film(123 , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5))) {
            System.out.printf ("В список %s добавить фильм 123 не удалось:\n", fls1.getName());
            System.out.println(" превышен лимит.");
        }

        if (!fls2.addFilm(new Film(2 , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5))) {
            System.out.printf ("В список %s добавить фильм 123 не удалось:\n", fls1.getName());
            System.out.println(" нарушена уникальность ключа.");
        }
        System.out.println();

        fls1.display();
        fls1.getGreaterAver().display();
        fls1.between(3.2f,4.2f).display();

        fls1.removeFilmById(2);
        System.out.println ("После удаления фильма:");
        fls1.display();
        System.out.println();


        fls2.display();
        fls2.getGreaterAver().display();
        fls2.between(3.2f,4.2f).display();

        fls2.removeFilmById(2);
        System.out.println ("После удаления фильма:");
        fls2.display();
        System.out.println();

        System.out.println("Проверка наличия фильма:");
        int n = 3;
        Film s1 = fls1.getFilmById(n);
        System.out.printf("В списке %s:\n", fls1.getName());
        if (s1 == null) System.out.printf ("Нет фильма с номером %d\n", n);
        else System.out.println(s1);
        n = 70000;
        s1 = fls1.getFilmById(n);
        if (s1 == null) System.out.printf("Нет фильма с номером %d\n",n);
        else System.out.println(s1);
        n = 53349;
        s1 = fls2.getFilmById(n);
        System.out.printf("В списке %s:\n", fls2.getName());
        if (s1 == null) System.out.printf ("Нет студента с номером зачетки %d\n",n);
        else System.out.println(s1);
        System.out.println();
        setListStatus(fls1, "сертификат А");
        setListStatus(fls2, "не сертифицирована");
        System.out.println("После назначения спискам статуса имеем:");
        System.out.println(fls1.getName()+";");
        System.out.println(fls2.getName()+".");
    }
}