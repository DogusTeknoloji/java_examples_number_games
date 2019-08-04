package com.dteknoloji.game.engines;

import com.dteknoloji.game.CheckResult;
import com.dteknoloji.game.GameEngine;

public class DefaultGameEngine implements GameEngine {
    private int minValue = 1;
    private int maxValue = 1000;
    private Integer randomNumber = null;
    private int trialIndex = 1;
    private int maxTrialCount = 10;

    public DefaultGameEngine() {
    }

    public DefaultGameEngine(int maxValue) {
        this.maxValue = maxValue;
    }

    public DefaultGameEngine(int minValue, int maxValue, int maxTrialCount) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxTrialCount = maxTrialCount;
    }

    @Override
    public int getMinValue() {
        return minValue;
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public int getTrialIndex() {
        return trialIndex;
    }

    @Override
    public int getMaxTrialCount() {
        return maxTrialCount;
    }

    @Override
    public Integer getRandomNumber() {
        return randomNumber;
    }

    @Override
    public void reset() {
        randomNumber = null;
        trialIndex = 1;
    }

    @Override
    public CheckResult check(int value) {
        if (trialIndex > maxTrialCount) return CheckResult.Lost;
        if (trialIndex == 1 && randomNumber == null) generateValue();
        if (randomNumber == value) return CheckResult.Win;
        trialIndex++;
        if (trialIndex > maxTrialCount) return CheckResult.Lost;
        return (randomNumber > value) ? CheckResult.Increase : CheckResult.Decrease;
    }

    private void generateValue() {
        randomNumber = (int) Math.round(minValue + Math.random() * (maxValue - minValue));
        trialIndex = 1;
    }
}
