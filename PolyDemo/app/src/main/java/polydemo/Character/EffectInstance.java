package polydemo.Character;

import polydemo.AppConfig;

public class EffectInstance {
    private double[] change = new double[4];
    private int duration;
    private boolean isPermanent;
    private final int initialDuration = duration;
    private String effectText;

    
    public void effectTick(AppConfig appVars){
        this.statChange(appVars);
        duration--;
    }

    public void statChange(AppConfig appVars) {
        appVars.player.setStrength(appVars.player.getStrength()+this.change[0]);
        appVars.player.setIntellect(appVars.player.getIntellect()+this.change[1]);
        appVars.player.setDexterity(appVars.player.getDexterity()+this.change[2]);
        appVars.player.setHealth(appVars.player.getHealth()+this.change[3]);
    }

    public void restitute(AppConfig appVars){
        appVars.player.setStrength(appVars.player.getStrength()-(this.change[0]*initialDuration));
        appVars.player.setIntellect(appVars.player.getIntellect()-(this.change[1]*initialDuration));
        appVars.player.setDexterity(appVars.player.getDexterity()-(this.change[2]*initialDuration));
        appVars.player.setHealth(appVars.player.getHealth()-(this.change[3]*initialDuration));
    }

    public double[] getChange() {
        return change;
    }

    public void setChange(double[] change) {
        this.change = change;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

    public int getInitialDuration() {
        return initialDuration;
    }

    public String getEffectText() {
        return effectText;
    }

    public void setEffectText(String effectText) {
        this.effectText = effectText;
    }

    public EffectInstance(double[] change, int duration, boolean isPermanent, String effectText) {
        this.change = change;
        this.duration = duration;
        this.isPermanent = isPermanent;
        this.effectText = effectText;
    }
}