package practice.second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ResultJournal journal = new ResultJournal("Кинофестивали");

        fillJournal(journal);

        System.out.println("Начальное состояние журнала учёта результатов кинофестивалей");
        journal.display();
        System.out.println("\n--------------------Запрос на добавление фильма--------------------------------");
        FilmKey filmKey = new FilmKey(9, "Монреальский кинофестиваль", "Empire Awards");
        if (!journal.addFilm(filmKey, 9)) {
            System.out.println("Запись нарушает правило уникальности ключа");
        }
        System.out.println("\n--------------------Запрос на обновлении записи о фильме--------------------------------");
        filmKey = new FilmKey(10, "Берлинский кинофестиваль", "Золотая малина");
        journal.updateFilm(filmKey, 51);
        journal.display();
        System.out.println("\n--------------------Запрос на выборку записей о фильме--------------------------------");
        journal.selectFilmData(3).sortAcsRank().display();
        System.out.println();
        journal.selectFestData("Берлинский кинофестиваль").sortAcsRank().display();
        System.out.println();
        journal.selectNominationData("Empire Awards").sortDescRank().display();
        System.out.println("\nВыборка из фильмов занявших места с 10 по 40");
        journal.selectBetweenRank(10, 40).sortAcsRank().display();
        System.out.println("\n--------------------Запросы на удаление записей о фильме--------------------------------");
        filmKey = new FilmKey(9, "Монреальский кинофестиваль", "Empire Awards");
        System.out.println("Удаление фильма " + filmKey);
        journal.delFilm(filmKey);
        journal.display();
        System.out.println();
        System.out.println("Попытка удаления несуществующей записи");
        if (!journal.delFilm(filmKey)) {
            System.out.println("Записи не существует");
        }
        System.out.println("Удаление фильма по id 4");
        journal.delFilm(4);
        journal.sortAcsRank().display();
    }

    private static void fillJournal(ResultJournal resultJournal) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("InputMap.txt"));
            while (sc.hasNext()) {
                String filmStr = sc.nextLine();
                String[] filmArr = filmStr.split(", ");
                int id = Integer.valueOf(filmArr[0]);
                String fest = filmArr[1];
                String nomination = filmArr[2];
                int rank = Integer.valueOf(filmArr[3]);
                resultJournal.addFilm(new FilmKey(id, fest, nomination), rank);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
