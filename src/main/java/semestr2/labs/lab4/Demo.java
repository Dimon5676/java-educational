package semestr2.labs.lab4;

public class Demo {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        FilmList fl1 = new FilmList(0, "Первый список", "", 0);
        FilmList fl2 = new FilmList(0, "Второй список", "", 0);

        String[] filmNames = {"Непрощенный", "Анон", "Такси 5", "Реинкарнация", "Атлантида"};
        String[] filmYears = {"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "3020"};

        for (int i = 0; i < 5; i++) {
            fl1.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5));
        }

        for (int i = 0; i < 5; i++) {
            fl2.addFilm(new Film(i , filmNames[(int) (Math.random()*filmNames.length)], filmYears[(int) (Math.random()*filmYears.length)], Math.random()*5));
        }

        System.out.println ("Сформированы следующие списки:");
        System.out.printf ("%s,\n%s\n\n", fl1, fl2);

        if (!fl1.addFilm(new Film(2, "Непрощенный","2001",5.0f))) {
            System.out.printf ("В список \"%s\" добавить фильм 2 не удалось:\n", fl1.getName());
            System.out.println(" нарушена уникальность ключа.\n");
        }

        fl1.display();
        fl1.aboveAver().display();
        fl1.between(3.2, 4.2).display();
        fl1.removeFilm(2);
        System.out.println();
        System.out.println("После удаления:");
        fl1.display();
        System.out.println();

        fl2.display();
        fl1.aboveAver().display();
        fl1.between(3.2, 4.2).display();
        fl2.removeFilm(3);
        System.out.println();
        System.out.println("После удаления:");
        fl2.display();
        System.out.println();

        Film f1 = fl1.findFilm(0);
        Film f2 = fl1.findFilm(2);
        if (f1 == null) {
            System.out.println("Нет такого фильма в списке");
        } else {
            System.out.println(f1);
        }
        if (f2 == null) {
            System.out.println("Нет такого фильма в списке");
        } else {
            System.out.println(f2);
        }

        System.out.println();

        f1 = fl2.findFilm(1);
        f2 = fl2.findFilm(3);
        if (f1 == null) {
            System.out.println("Нет такого фильма в списке");
        } else {
            System.out.println(f1);
        }
        if (f2 == null) {
            System.out.println("Нет такого фильма в списке");
        } else {
            System.out.println(f2);
        }
    }
}
