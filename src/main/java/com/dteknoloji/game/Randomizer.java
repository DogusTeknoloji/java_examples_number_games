package com.dteknoloji.game;

public interface Randomizer {
    double next();
    int nextInteger();
    int nextInteger(int maxValue);
    int nextInteger(int minValue, int maxValue);
}
