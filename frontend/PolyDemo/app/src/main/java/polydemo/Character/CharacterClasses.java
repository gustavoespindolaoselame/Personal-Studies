package polydemo.Character;

import polydemo.AppConfig;
import polydemo.Enemies.EnemyClasses;

public abstract class CharacterClasses {
    protected double strength;
    protected double intellect;
    protected double dexterity;
    protected int exp = 0;
    protected double health = 100;
    protected String name;
    protected String[] spellNames = new String[6];
    
    public abstract void defaultAttack();

    public int displaySpells(AppConfig AppVars){
        System.out.println("(1) - Atacar;");

        for(int i=0;i<exp/10&&i<5;i++){
        System.out.println("(" + (i+2) + ")" + " - " + this.spellNames[i] + ";");
        }

        return AppVars.scanner.nextInt();
    }

    public abstract void ability1(EnemyClasses inimigo);

    public abstract void ability2(EnemyClasses inimigo);

    public abstract void ability3(EnemyClasses inimigo);

    public abstract void ability4(EnemyClasses inimigo);

    public abstract void ability5(EnemyClasses inimigo);

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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
