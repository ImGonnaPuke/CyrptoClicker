package com.cryptoclicker.classified.cryptoclicker;

/**
 * Created by Miguel on 1/31/2018.
 */

public class Achieve {
    private int cryCount; // Total score
    private int unlockCount; //Score needed to unlock
    private boolean needsCount; // Differentiates score based achievements and upgrade based achievements
    private boolean hasUpgrade; // Tells if the required achievement is aquired
    private int hasUpgrades; // Setup for checking higher numbers of the same upgrades
    private boolean unlock;  // Shows the achievements is unlocked
    private int effect; // Possible system for determining rewards
    private int min; // minimum value for progress bar, should probably always be zero
    private int max; // max value for progress bar
    private String tag;  // Written requirement for the achievement

    /**
     * Constructor for score based achievements
     * @param unlockCount
     * @param effect
     * @param tag
     */
    public Achieve(int unlockCount, int effect, String tag) {
        this.unlockCount = unlockCount;
        this.effect = effect;
        this.unlock = false;
        this.needsCount = true;
        this.min = 0;
        this.max = unlockCount;
        this.tag = tag;
    }

    /**
     * Placeholder constructor for upgrade achievements
     * @param effect
     * @param tag
     */

    public Achieve(int effect, String tag) {
        this.min = 0;
        this.max = 1;
        this.effect = effect;
        this.tag = tag;
    }

    /**
     * Method to check for completed upgrade achievements
     */

    public void hasUp()
    {
        this.hasUpgrade = true;
    }

    /**
     * Method to mark achievements as unlocked
     */

    public void unlocked() {
        this.unlock = true;
    }

    /**
     * Checks if the required score has been reached
     */

    public void checkCount() {
        if (needsCount == true) {
            if (cryCount >= unlockCount) {
                this.unlocked();
            }
        }
    }
}
