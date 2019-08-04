package com.dteknoloji.game;

public class DefaultRandomizer implements Randomizer {

    @Override
    public double next() {
        return Math.random();
    }

    @Override
    public int nextInteger() {
        return nextInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public int nextInteger(int maxValue) {
        return nextInteger(0, maxValue);
    }

    @Override
    public int nextInteger(int minValue, int maxValue) {
        return (int) Math.round(minValue + Math.random() * (maxValue - minValue));
    }
}
