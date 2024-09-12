package polydemo.Character;

import polydemo.Enemies.EnemyClasses;

public final class Wizard extends CharacterClasses{
    
    public Wizard() {
        this.strength=1;
        this.intellect=6;
        this.dexterity=2;
        this.name = "Mago";
        this.spellNames[0] = "Foguinho";
        this.spellNames[1] = "Fogasso";
        this.spellNames[2] = "Águinha";
        this.spellNames[3] = "Águasso";
        this.spellNames[4] = "Apocalipse";
    }

    @Override
    public void defaultAttack(){
        System.err.println(name + " Enfeitiçou!");
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
