package com.dteknoloji.game.engines;

import com.dteknoloji.game.CheckResult;
import com.dteknoloji.game.GameEngine;
import com.dteknoloji.game.Randomizer;

public class DefaultGameEngine implements GameEngine {
    private int minValue = 1;
    private int maxValue = 1000;
    private Integer randomNumber = null;
    private int trialIndex = 1;
    private int maxTrialCount = 10;
    private final Randomizer randomizer;

    public DefaultGameEngine(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public int getMinValue() {
        return minValue;
    }

    @Override
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public int getTrialIndex() {
        return trialIndex;
    }

    @Override
    public void setTrialIndex(int trialIndex) {
        this.trialIndex = trialIndex;
    }

    @Override
    public int getMaxTrialCount() {
        return maxTrialCount;
    }

    @Override
    public void setMaxTrialCount(int maxTrialCount) {
        this.maxTrialCount = maxTrialCount;
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
        randomNumber = randomizer.nextInteger(minValue, maxValue);
        trialIndex = 1;
    }
}
