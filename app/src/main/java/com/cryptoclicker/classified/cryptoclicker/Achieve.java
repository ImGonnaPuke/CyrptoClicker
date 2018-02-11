package com.cryptoclicker.classified.cryptoclicker;

/**
 * Created by Miguel on 1/31/2018.
 */

public class Achieve {
    private int cryCount;
    private int unlockCount;
    private boolean needsCount;
    private boolean hasUpgrade;
    private int hasUpgrades;
    private boolean unlock;
    private int effect;
    private int min;
    private int max;
    private String tag;

    public Achieve(int unlockCount, int effect, String tag) {
        this.unlockCount = unlockCount;
        this.effect = effect;
        this.unlock = false;
        this.needsCount = true;
        this.min = 0;
        this.max = unlockCount;
        this.tag = tag;
    }

    public Achieve(int effect, String tag) {
        this.min = 0;
        this.max = 1;
        this.effect = effect;
        this.tag = tag;
    }

    public void hasUp()
    {
        this.hasUpgrade = true;
    }

    public void unlocked() {
        this.unlock = true;
    }

    public void checkCount() {
        if (needsCount == true) {
            if (cryCount >= unlockCount) {
                this.unlocked();
            }
        }
    }
}
