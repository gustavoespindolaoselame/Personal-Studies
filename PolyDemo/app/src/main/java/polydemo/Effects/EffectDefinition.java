package polydemo.Effects;

public enum EffectDefinition {
    POISON(new double[]{1,2,3,4}, 2, false, "poisoned you;;Poison dealt"), 
    FIRE(new double[]{5,6,7,8}, 3, true, "put you on fire;;Fire dealt"), 
    DROWZY(new double[]{9,10,11,12}, 4, false, "made you drowzy;;Drowzyness dealt"), 
    CONFUSED(new double[]{13,14,15,16}, 5, true, "made you confused;;Confusion dealt");

    public double[] change = new double[4];
    public int duration;
    public boolean isPermanent;
    public String effectText;

    EffectDefinition(double[] change, int duration, boolean isPermanent, String effectText) {
        this.change = change;
        this.duration = duration;
        this.isPermanent = isPermanent;
        this.effectText = effectText;
    }
}
