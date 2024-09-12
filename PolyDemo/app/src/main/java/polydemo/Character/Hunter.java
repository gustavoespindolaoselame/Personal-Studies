package polydemo.Character;
import polydemo.Enemies.EnemyClasses;

public final class Hunter extends CharacterClasses{

    public Hunter() {
        this.strength=2;
        this.intellect=2;
        this.dexterity=5;
        this.name = "Caçador";
        this.spellNames[0] = "Tiro rápido";
        this.spellNames[1] = "Tiro Longo";
        this.spellNames[2] = "Tiro desorientante";
        this.spellNames[3] = "Tiro fatal";
        this.spellNames[4] = "Tiro vampírico";
    }

    @Override
    public final void defaultAttack(){
        System.err.println(name + " Atirou!");
    }

    @Override
    public final void ability1(EnemyClasses inimigo){
        System.err.println(name + " Atirou rapidamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (this.getStrength()+this.getDexterity()));
    }

    @Override
    public final void ability2(EnemyClasses inimigo){
        System.err.println(name + " Atirou longamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (2*this.getDexterity()));
    }

    @Override
    public final void ability3(EnemyClasses inimigo){
        System.err.println(name + " Atirou desorientantemente!");
        inimigo.setHealth(
            inimigo.getHealth() - (5*this.getIntellect()));
    }

    @Override
    public final void ability4(EnemyClasses inimigo){
        System.err.println(name + " Atirou Fatalmente!");
        inimigo.setHealth(
            inimigo.getHealth() - ((10*this.getStrength())-(2*this.getDexterity())));
    }

    @Override
    public final void ability5(EnemyClasses inimigo){
        System.err.println(name + " Atirou Vampíricamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (2*this.getDexterity()));
            this.health+=(2*this.getDexterity());
    }

}
