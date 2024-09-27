package polydemo.Enemies;

import polydemo.*;
import polydemo.Effects.EffectDefinition;

public abstract class EnemySpells{
    public final void ability0(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " bicou");
        appVars.player.effectsApply(EffectDefinition.POISON);
    }
    public final void ability1(AppConfig appVars){
        appVars.Inimigos.get(appVars.currentEnemy).setHealth(appVars.Inimigos.get(appVars.currentEnemy).getHealth()*1.5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " recuperou");
        appVars.player.effectsApply(EffectDefinition.FIRE);
    }
    public final void ability2(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-10);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " socou");
        appVars.player.effectsApply(EffectDefinition.DROWZY);
    }
    public final void ability3(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-10);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " atirou flecha");
        appVars.player.effectsApply(EffectDefinition.CONFUSED);
    }
    public final void ability4(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " bateu com um porrete");
    }
    public final void ability5(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " chutou");
    }
    public final void ability6(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " pisou");
    }
    public final void ability7(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-20);
        appVars.player.setStrength(appVars.player.getStrength()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " esmagou");
    }
    public final void ability8(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-25);
        appVars.player.setStrength(appVars.player.getStrength()-5);
        appVars.player.setIntellect(appVars.player.getIntellect()-5);
        appVars.player.setDexterity(appVars.player.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " aterrorizou");
    }
    public final void ability9(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-25);
        appVars.player.setDexterity(appVars.player.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " incinerou");
    }
    public final void ability10(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-20);
        appVars.player.setDexterity(appVars.player.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " queimou");
    }
    public final void ability11(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-10);
        appVars.player.setStrength(appVars.player.getStrength()-7);
        appVars.player.setIntellect(appVars.player.getIntellect()-7);
        appVars.player.setDexterity(appVars.player.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " gritou");
    }
    public final void ability12(AppConfig appVars){
        appVars.player.setStrength(appVars.player.getStrength()-7);
        appVars.player.setIntellect(appVars.player.getIntellect()-7);
        appVars.player.setDexterity(appVars.player.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " melecou");
    }
    public final void ability13(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-40);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " destruiu");
    }
    public final void ability14(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-40);
        appVars.player.setStrength(appVars.player.getStrength()-7);
        appVars.player.setIntellect(appVars.player.getIntellect()-7);
        appVars.player.setDexterity(appVars.player.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " lançou uma bola de caos");
    }
    public final void ability15(AppConfig appVars){
        appVars.player.setHealth(appVars.player.getHealth()-50);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " desmaterializou");
    }
}
