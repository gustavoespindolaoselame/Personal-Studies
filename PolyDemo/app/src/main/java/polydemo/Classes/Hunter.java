package polydemo.Classes;
import polydemo.PlayerCharacter;
import polydemo.Enemies.EnemyCharacter;

public final class Hunter extends PlayerCharacter{

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
    public final void ability1(EnemyCharacter inimigo){
        System.err.println(name + " Atirou rapidamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (this.getStrength()+this.getDexterity()));
    }

    @Override
    public final void ability2(EnemyCharacter inimigo){
        System.err.println(name + " Atirou longamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (2*this.getDexterity()));
    }

    @Override
    public final void ability3(EnemyCharacter inimigo){
        System.err.println(name + " Atirou desorientantemente!");
        inimigo.setHealth(
            inimigo.getHealth() - (5*this.getIntellect()));
    }

    @Override
    public final void ability4(EnemyCharacter inimigo){
        System.err.println(name + " Atirou Fatalmente!");
        inimigo.setHealth(
            inimigo.getHealth() - ((10*this.getStrength())-(2*this.getDexterity())));
    }

    @Override
    public final void ability5(EnemyCharacter inimigo){
        System.err.println(name + " Atirou Vampíricamente!");
        inimigo.setHealth(
            inimigo.getHealth() - (2*this.getDexterity()));
            this.health+=(2*this.getDexterity());
    }

}
