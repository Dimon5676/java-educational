package semestr2.labs.lab6;

public class Test {

    @SuppressWarnings("Duplicates")
    public static void main (String[] args){
        int N = 4;

        Sentence sent = new Sentence(" А Алиса спрятала ключик под коврик ");
        System.out.println(sent);
        System.out.println();
        System.out.println("Слова исходной строки:");
        display(sent.getWords());
        System.out.println();
        System.out.printf("Вывести слова длиной больше %d символов\n", N);
        display(sent.wordsLengthAboveN(N));
        System.out.println();
        System.out.println("Вывести слова, у которых первая и последняя буква одинаковые");
        display(sent.wordsLetterFirstEqvLast ());
        System.out.println();
        System.out.println("Сделать первую букву каждого слова в предложении заглавной");
        System.out.println(sent.capitalFirstLetterInWords());
        System.out.println();
        System.out.println("Убрать из предложения слова, длина которых меньше или равна "+N);
        System.out.println(sent.deleteWordsLengthAboveN(N));
        System.out.println();

        System.out.println ("Предложение, полученное из исходного следующим образом: \n"+
                        "сначала удалены слова, длина которых меньше или равна "+N+", \n"+
                        "а затем первые буквы слов сделаны заглавными:");
        System.out.println();
        System.out.println("Вывести массив слов, начинающихся на букву \'a\'");
        display(sent.wordsLetterFirstEqvA());
        System.out.println();
        System.out.println("строку, в которой оставлены слова, оканчивающиеся на заданную букву и начинающиеся на букву \'a\'.");
        System.out.println(sent.wordsLetterFirstEqvALastEqvN('t'));
        Sentence sent1 = new Sentence(sent.deleteWordsLengthAboveN(N));
        sent1 = new Sentence(sent1.capitalFirstLetterInWords());
        System.out.println(sent1);
        System.out.println();
        System.out.println("Слова исходной строки нового предложения:");
        display(sent1.getWords());
        System.out.println();
        N = 5;
        System.out.printf("Вывести слова длиной больше %d символов\n",N);
        display(sent1.wordsLengthAboveN(N));
        System.out.println();
        System.out.println("Вывести слова, у которых первая и последняя буква одинаковые");
        display(sent1.wordsLetterFirstEqvLast ());
        System.out.println();
        System.out.println("Создаем предложение с пустой строкой и поочередно");
        System.out.println("запускаем методы обработки предложения ");
        Sentence sent2 = new Sentence();
        display(sent2.getWords());
        display(sent2.wordsLengthAboveN(N));
        display(sent2.wordsLetterFirstEqvLast());
        System.out.println(sent2.capitalFirstLetterInWords());
        System.out.println(sent2.deleteWordsLengthAboveN(N));
        System.out.println("Вывести массив слов, начинающихся на букву \'a\'");
        display(sent2.wordsLetterFirstEqvA());
        System.out.println();
        System.out.println("строку, в которой оставлены слова, оканчивающиеся на заданную букву и начинающиеся на букву \'a\'.");
        System.out.println(sent2.wordsLetterFirstEqvALastEqvN('t'));
    }

    public static void display(String[] strings){
        if (strings == null) return;
        for (String i : strings){
            if (i == null) break;
            System.out.println(i);
        }
    }
}