package polydemo.Character;

import polydemo.Enemies.EnemyClasses;

public final class Warrior extends CharacterClasses{

    public Warrior() {
        this.strength=5;
        this.intellect=0;
        this.dexterity=4;
        this.name = "Guerreiro";
        this.spellNames[0] = "Porrada";
        this.spellNames[1] = "Porrada violenta";
        this.spellNames[2] = "Porrada foda";
        this.spellNames[3] = "Porrada enlouquecida";
        this.spellNames[4] = "Porrada da hora";
    }

    @Override
    public void defaultAttack(){
        System.err.println(name + " Socou");
    }

    @Override
    public final void ability1(EnemyClasses inimigo){

    }

    @Override
    public final void ability2(EnemyClasses inimigo){

    }

    @Override
    public final void ability3(EnemyClasses inimigo){

    }

    @Override
    public final void ability4(EnemyClasses inimigo){

    }

    @Override
    public final void ability5(EnemyClasses inimigo){

    }

}
