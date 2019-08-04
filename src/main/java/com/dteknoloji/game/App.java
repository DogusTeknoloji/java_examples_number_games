package com.dteknoloji.game;

import com.dteknoloji.game.engines.DefaultGameEngine;
import com.dteknoloji.game.games.GuessTheNumberGame;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine gameEngine = new DefaultGameEngine(1, 1000, 10);
        Game game = new GuessTheNumberGame(gameEngine, scanner);
        while (true) {
            game.run();
            System.out.println("Tekrar oynamak ister misiniz?(E,H)");
            String choice = scanner.next(Pattern.compile("[EeHh]"));
            if (!choice.equals("E") && !choice.equals("e")) {
                System.out.println("Tekrar görüşmek üzere");
                break;
            }
        }
    }
}
