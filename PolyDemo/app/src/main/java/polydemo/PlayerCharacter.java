package polydemo;

import java.util.ArrayList;
import java.util.List;

import polydemo.Effects.EffectDefinition;
import polydemo.Effects.EffectInstance;
import polydemo.Enemies.EnemyCharacter;

import polydemo.Classes.CharacterClasses;

public abstract class PlayerCharacter extends AppConfig{
    protected double strength;
    protected double intellect;
    protected double dexterity;
    protected int exp = 0;
    protected double health = 100;
    protected String name;
    protected String[] spellNames = new String[6];
    public List<EffectInstance> effectsApplied = new ArrayList<>(); 
    
    public abstract void defaultAttack();

    public void displaySpells(AppConfig AppVars){
        System.out.println("(1) - Atacar;");

        for(int i=0;i<exp/10&&i<5;i++){
        System.out.println("(" + (i+2) + ")" + " - " + this.spellNames[i] + ";");
        }
    }

    public void effectsApply(EffectDefinition effect){
        for (EffectInstance effectNames : effectsApplied) {
            if(effectNames.getEffectText().equals(effect.effectText)){
                return;
            }
        }
        effectsApplied.add(new EffectInstance(effect.change, effect.duration, effect.isPermanent, effect.effectText));
        System.out.println(Inimigos.get(currentEnemy).getName() + " " + effect.effectText.split(";;", 2)[0]);
    }

    public void effectsAppliedTick(AppConfig appVars){
        for (int i = 0;i<effectsApplied.size();i++) {
            if(effectsApplied.get(i).getDuration()<=0){
                if(!effectsApplied.get(i).isPermanent()){
                    effectsApplied.get(i).restitute(appVars);
                }
                effectsApplied.remove(i);
                break;
            }
            effectsApplied.get(i).effectTick(appVars);
            System.out.println(effectsApplied.get(i).getEffectText().split(";;", 2)[1] + " " + effectsApplied.get(i).getChange()[1] + " of damage");
        }
    }

    public abstract void ability1(EnemyCharacter inimigo);

    public abstract void ability2(EnemyCharacter inimigo);

    public abstract void ability3(EnemyCharacter inimigo);

    public abstract void ability4(EnemyCharacter inimigo);

    public abstract void ability5(EnemyCharacter inimigo);

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

    public void effectsApply(double d, int i, boolean b, String testeteste) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
