package com.dteknoloji.game.games;

import com.dteknoloji.game.CheckResult;
import com.dteknoloji.game.Game;
import com.dteknoloji.game.GameEngine;

import java.io.PrintStream;
import java.util.Scanner;

public class GuessTheNumberGame implements Game {
    private final GameEngine game;
    private final Scanner scanner;
    private final PrintStream output;

    public GuessTheNumberGame(GameEngine game, Scanner scanner, PrintStream output) {
        this.game = game;
        this.scanner = scanner;
        this.output = output;
    }

    public void run() {
        output.println("Sayı Bulma Oyunu");
        game.reset();
        loop:
        while (true) {
            output.print(game.getTrialIndex() + ". Şansınız: ");
            int result = scanner.nextInt();
            CheckResult checkResult = game.check(result);
            switch (checkResult) {
                case Win:
                    output.println("Cevabı bildiniz. Tebrikler");
                    break loop;
                case Increase:
                    output.println("Cevabınızı büyütmeniz lazım!");
                    break;
                case Decrease:
                    output.println("Cevabınızı küçültmeniz lazım!");
                    break;
                case Lost:
                    output.printf("Maalesef bilemediniz. Cevap : %d olacaktı.\n", game.getRandomNumber());
                    break loop;
            }
        }
    }
}
