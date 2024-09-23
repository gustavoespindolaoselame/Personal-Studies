package polydemo.Enemies;

import polydemo.AppConfig;

public abstract class EnemySpells {
    public final void ability0(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " bicou");
    }
    public final void ability1(AppConfig appVars){
        appVars.Inimigos.get(appVars.currentEnemy).setHealth(appVars.Inimigos.get(appVars.currentEnemy).getHealth()*1.5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " recuperou");
    }
    public final void ability2(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-10);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " socou");
    }
    public final void ability3(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-10);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " atirou flecha");
    }
    public final void ability4(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " bateu com um porrete");
    }
    public final void ability5(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " chutou");
    }
    public final void ability6(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-15);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " pisou");
    }
    public final void ability7(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-20);
        appVars.classe.setStrength(appVars.classe.getStrength()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " esmagou");
    }
    public final void ability8(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-25);
        appVars.classe.setStrength(appVars.classe.getStrength()-5);
        appVars.classe.setIntellect(appVars.classe.getIntellect()-5);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " aterrorizou");
    }
    public final void ability9(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-25);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " incinerou");
    }
    public final void ability10(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-20);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-5);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " queimou");
    }
    public final void ability11(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-10);
        appVars.classe.setStrength(appVars.classe.getStrength()-7);
        appVars.classe.setIntellect(appVars.classe.getIntellect()-7);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " gritou");
    }
    public final void ability12(AppConfig appVars){
        appVars.classe.setStrength(appVars.classe.getStrength()-7);
        appVars.classe.setIntellect(appVars.classe.getIntellect()-7);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " melecou");
    }
    public final void ability13(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-40);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " destruiu");
    }
    public final void ability14(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-40);
        appVars.classe.setStrength(appVars.classe.getStrength()-7);
        appVars.classe.setIntellect(appVars.classe.getIntellect()-7);
        appVars.classe.setDexterity(appVars.classe.getDexterity()-7);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " lançou uma bola de caos");
    }
    public final void ability15(AppConfig appVars){
        appVars.classe.setHealth(appVars.classe.getHealth()-50);
        System.out.println(appVars.Inimigos.get(appVars.currentEnemy).name + " desmaterializou");
    }
}
