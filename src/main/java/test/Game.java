package test;

import java.util.Scanner;

public class Game {

    private boolean isEnd = false;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Game();
    }

    private Game() {
        while (!isEnd) {
            String num = "";
            for (int i = 0; i < 4; i++) {
                String temp = String.valueOf((int)((Math.random()*9)+1));
                while (num.contains(temp)) {
                    temp = String.valueOf((int)(Math.random()*10));
                }
                num += temp;
            }
            System.out.println("Введи число:");
            int playerNum = sc.nextInt();
            String player = String.valueOf(playerNum);
            while (player.length() != 4) {
                System.out.println("Число должно быть четырёх значным");
                System.out.println("Попробуй ещё раз");
                playerNum = sc.nextInt();
                player = String.valueOf(playerNum);
            }


            System.out.println(num);
            System.out.println(player);
            isEnd = true;
        }
    }
}
