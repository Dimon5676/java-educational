package labs.lab1;

import java.util.Date;

public class Info {

    public static void main (String[] args) {
        String firstName = "Дмитрий";
        String middleName = "Романович";
        String lastName = "Лозыченко";
        String teacherFirstName = "Елена";
        String teacherMiddleName = "Сергеевна";
        String teacherLastName = "Владимирова";
        String groupCode = "ИВТ/б-11-о";
        int variant = 12;
        int longPool = 69;
        int widthPool = 900;
        String fullName = fullName(firstName, middleName, lastName);

        System.out.println("Программу выполнил:");
        System.out.println(fullName);
        System.out.println("Шифр группы: " + groupCode);
        System.out.println("Дата " + new Date());
        System.out.println("Вариант: " + variant);
        System.out.println("Длина бассейна: " + longPool);
        System.out.println("Ширина бассейна: " + widthPool);
        System.out.println("Площадь бассейна: " + longPool * widthPool);
        System.out.println("Проверил: \n" + fullName(teacherFirstName, teacherMiddleName, teacherLastName));
    }



    public static String fullName(String a, String b, String c){

      return a + " " + b + " " + c;
    }
}