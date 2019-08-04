package com.dteknoloji.game;

public interface GameEngine {
    int getMinValue();

    int getMaxValue();

    int getMaxTrialCount();

    int getTrialIndex();

    Integer getRandomNumber();

    void reset();

    CheckResult check(int value);
}

