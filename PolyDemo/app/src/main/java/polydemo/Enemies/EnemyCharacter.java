package polydemo.Enemies;

import java.util.ArrayList;

import polydemo.AppConfig;

public final class EnemyCharacter extends EnemySpells {

    protected double strength;
    protected double intellect;
    protected double dexterity;
    protected double health;
    protected double experience;
    protected double level;
    protected String name;
    protected ArrayList<Integer> hasSpellId;

    public void castSpell(AppConfig appVars) {
        switch (this.hasSpellId.get((int) (Math.random() * this.hasSpellId.size()))) {
            case 0 -> this.ability0(appVars);
            case 1 -> this.ability1(appVars);
            case 2 -> this.ability2(appVars);
            case 3 -> this.ability3(appVars);
            case 4 -> this.ability4(appVars);
            case 5 -> this.ability5(appVars);
            case 6 -> this.ability6(appVars);
            case 7 -> this.ability7(appVars);
            case 8 -> this.ability8(appVars);
            case 9 -> this.ability9(appVars);
            case 10 -> this.ability10(appVars);
            case 11 -> this.ability11(appVars);
            case 12 -> this.ability12(appVars);
            case 13 -> this.ability13(appVars);
            case 14 -> this.ability14(appVars);
            case 15 -> this.ability15(appVars);
            default -> throw new AssertionError();
        }
    }

    public void defaultAttack() {
        System.err.println(name + " Atacou!");
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getIntellect() {
        return intellect;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public ArrayList<Integer> getHasSpellId() {
        return hasSpellId;
    }

    public void setHasSpellId(ArrayList<Integer> hasSpellId) {
        this.hasSpellId = hasSpellId;
    }

}
