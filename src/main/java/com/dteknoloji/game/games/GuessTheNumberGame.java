package com.dteknoloji.game.games;

import com.dteknoloji.game.CheckResult;
import com.dteknoloji.game.Game;
import com.dteknoloji.game.GameEngine;

import java.util.Scanner;

public class GuessTheNumberGame implements Game {
    private GameEngine game;
    private Scanner scanner;

    public GuessTheNumberGame(GameEngine game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("Sayı Bulma Oyunu");
        game.reset();
        loop:
        while (true) {
            System.out.print(game.getTrialIndex() + ". Şansınız: ");
            int result = scanner.nextInt();
            CheckResult checkResult = game.check(result);
            switch (checkResult) {
                case Win:
                    System.out.println("Cevabı bildiniz. Tebrikler");
                    break loop;
                case Increase:
                    System.out.println("Cevabınızı büyütmeniz lazım!");
                    break;
                case Decrease:
                    System.out.println("Cevabınızı küçültmeniz lazım!");
                    break;
                case Lost:
                    System.out.printf("Maalesef bilemediniz. Cevap : %d olacaktı.\n", game.getRandomNumber());
                    break loop;
            }
        }
    }
}
