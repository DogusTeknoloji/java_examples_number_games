package com.dteknoloji.game;

public interface GameEngine {
    int getMinValue();
    void setMinValue(int minValue);

    int getMaxValue();
    void setMaxValue(int maxValue);

    int getMaxTrialCount();
    void setMaxTrialCount(int maxTrialCount);

    int getTrialIndex();
    void setTrialIndex(int trialIndex);

    Integer getRandomNumber();

    void reset();

    CheckResult check(int value);
}

