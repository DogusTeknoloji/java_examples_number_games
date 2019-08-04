package com.dteknoloji.game;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Sayı Bulma Oyunu");
        int tutulanSayi = (int) Math.round(Math.random() * 1000);
        boolean bildi = false;
        Scanner scanner = new Scanner(System.in);
        for (int sans = 1; sans <= 10; sans++) {
            System.out.print(sans + ". Şansınız: ");
            int cevap = scanner.nextInt();
            if (cevap == tutulanSayi) {
                System.out.println("Cevabı bildiniz. Tebrikler");
                bildi = true;
                break;
            }
            if (cevap > tutulanSayi) {
                System.out.println("Cevabınızı küçültmeniz lazım!");
            } else if (cevap < tutulanSayi) {
                System.out.println("Cevabınızı büyütmeniz lazım!");
            }
        }
        if (!bildi) {
            System.out.printf("Maalesef bilemediniz. Cevap : %d olacaktı.\n", tutulanSayi);
        }
    }
}
