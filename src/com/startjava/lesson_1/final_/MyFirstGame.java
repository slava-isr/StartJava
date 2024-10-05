package com.startjava.lesson_1.final_;

public class MyFirstGame {

    public static void main(String[] args) {
        int guessNum = 14;
        int playerNum = 25;
        while (guessNum != playerNum) {
            if (guessNum < playerNum) {
                System.out.println(playerNum + " больше того, что загадал компьютер");
                playerNum--;
            } else if (guessNum > playerNum) {
                System.out.println(playerNum + " меньше того, что загадал компьютер");
                playerNum++;
            }
        }
        System.out.println("Вы победили!");
    }
}