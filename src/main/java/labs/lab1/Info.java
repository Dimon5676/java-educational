package labs.lab1;

import java.util.Date;

/**
 * Test class for the first lab of programming course
 * in Sevastopol State University
 */

public class Info {
    /**
     * Main method
     * @param args array of args
     */
    public static void main (String[] args) {
        /** name of the student */
        String firstName = "Дмитрий";
        /** middle name of the student */
        String middleName = "Романович";
        /** last name of the student */
        String lastName = "Лозыченко";
        /** first name of the teacher */
        String teacherFirstName = "Елена";
        /** middle name of the teacher */
        String teacherMiddleName = "Сергеевна";
        /** last name of the teacher */
        String teacherLastName = "Владимирова";
        /** code of the student's group */
        String groupCode = "ИВТ/б-11-о";
        /** number of student's variant */
        int variant = 12;
        /** length of the pool */
        int longPool = 341;
        /** width of the pool */
        int widthPool = 91;
        /** full name of teacher or student */
        String fullName = fullName(firstName, middleName, lastName);
        /** square of pool */
        int result = longPool * widthPool;
        System.out.println("Программу выполнил:");
        System.out.println(fullName);
        System.out.println("Шифр группы: " + groupCode);
        System.out.println("Дата " + new Date());
        System.out.println("Вариант: " + variant);
        System.out.println("Длина бассейна: " + longPool);
        System.out.println("Ширина бассейна: " + widthPool);
        System.out.println("Площадь бассейна: " + result);
        System.out.println("Проверил: \n" + fullName(teacherFirstName, teacherMiddleName, teacherLastName));
    }


    /**
     * Returns full name
     *
     * @param a first name
     * @param b middle name
     * @param c last name
     * @return full name
     */
    public static String fullName(String a, String b, String c){

      return a + " " + b + " " + c;
    }
}