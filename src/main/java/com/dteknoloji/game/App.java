package com.dteknoloji.game;

import com.dteknoloji.game.engines.DefaultGameEngine;
import com.dteknoloji.game.games.GuessTheNumberGame;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        PrintStream output = System.out;
        Scanner scanner = new Scanner(System.in);
        Randomizer randomizer = new DefaultRandomizer();
        GameEngine gameEngine = new DefaultGameEngine(randomizer);
        Game game = new GuessTheNumberGame(gameEngine, scanner, output);
        while (true) {
            game.run();
            output.println("Tekrar oynamak ister misiniz?(E,H)");
            String choice = scanner.next(Pattern.compile("[EeHh]"));
            if (!choice.equals("E") && !choice.equals("e")) {
                output.println("Tekrar görüşmek üzere");
                break;
            }
        }
    }
}
