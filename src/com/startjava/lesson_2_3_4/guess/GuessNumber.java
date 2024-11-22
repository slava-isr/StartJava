package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    public static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    private final Player[] players;
    private final int rangeFrom;
    private final int rangeTo;
    private int guessNumber;

    public GuessNumber(Player[] players, int rangeFrom, int rangeTo) {
        this.players = players;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public void start(Scanner sc) {
        shuffle();
        System.out.printf("%nИгра началась! У каждого игрока по %d попыток.", MAX_ATTEMPTS);
        for (int round = 1; round <= MAX_ROUNDS; round++) {
            generateGuessNumber();
            boolean hasWinner = false;
            for (int attempt = 1; attempt <= MAX_ATTEMPTS && !hasWinner; attempt++) {
                System.out.printf("%n%n--== %d-Й РАУНД | %d-Я ПОПЫТКА ==--", round, attempt);
                for (Player player : players) {
                    System.out.printf("%n%nОтвечает %s: ", player.getName());
                    if (isGuess(player, sc, attempt)) {
                        hasWinner = true;
                        break;
                    }
                    if (attempt == MAX_ATTEMPTS) {
                        System.out.printf("%n%nУ %s закончились попытки!", player.getName());
                    }
                }
                if (hasWinner || (attempt == MAX_ATTEMPTS)) printStats(round);
            }
        }
    }

    private void shuffle() {
        System.out.println("\nБросаю жребий, кто ходит первый...");
        for (int i = players.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }
    }

    private void generateGuessNumber() {
        guessNumber = rangeFrom + (int) (Math.random() * (rangeTo - rangeFrom + 1));
        System.out.printf("%n%nЗагадано число в отрезке [%d, %d]", rangeFrom, rangeTo);
    }

    private boolean isGuess(Player player, Scanner sc, int attempt) {
        int enteredNumber;
        while (true) {
            try {
                enteredNumber = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf("Можно ввести только целое число в отрезке [%d, %d].%n%nПопробуйте еще раз: ",
                        rangeFrom, rangeTo);
                continue;
            }
            if (enteredNumber < rangeFrom || enteredNumber > rangeTo) {
                System.out.printf("Число должно входить в отрезок [%d, %d].%n%nПопробуйте еще раз: ",
                        rangeFrom, rangeTo);
                continue;
            }
            if (player.setNumbers(enteredNumber)) {
                if (enteredNumber == guessNumber) {
                    System.out.printf("%n%s угадал число %d с %d-й попытки", player.getName(), guessNumber, attempt);
                    player.setWinCount();
                    return true;
                }
                System.out.printf("Ваше число %s загаданного", (enteredNumber > guessNumber ? "больше" : "меньше"));
                return false;
            }
        }
    }

    private void printStats(int round) {
        System.out.printf("%n%n--== КОНЕЦ %d-ГО РАУНДА ==--%n", round);
        for (Player player : players) {
            System.out.printf("%nЧисла игрока %s: %s",
                    player.getName(), Arrays.toString(player.getNumbers()).replaceAll("[\\[\\],]", ""));
            player.clearNumbers();
        }
        if (round == MAX_ROUNDS) {
            String winnerName = players[0].getName();
            int winCount = players[0].getWinCount();
            boolean isDraw = false;
            for (int i = 1; i < players.length; i++) {
                if (players[i].getWinCount() > winCount) {
                    winnerName = players[i].getName();
                    winCount = players[i].getWinCount();
                    isDraw = false;
                } else if (players[i].getWinCount() == winCount) {
                    winnerName = String.format("%s и %s", winnerName, players[i].getName());
                    isDraw = true;
                }
            }
            System.out.printf("%n%n<-<-<- ИГРА ОКОНЧЕНА ->->->");
            if (isDraw) {
                System.out.printf("%n%n%s%n", winCount > 0 ?
                        "У " + winnerName + " ничья с результатом " + winCount :
                        "Победителей нет, никто не смог отгадать число");
            } else {
                System.out.printf("%n%nПобедитель - %s с результатом %d%n", winnerName, winCount);
            }
        }
    }
}