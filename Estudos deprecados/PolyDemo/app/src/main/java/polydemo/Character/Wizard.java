package polydemo.Character;

import polydemo.Enemies.EnemyCharacter;

public final class Wizard extends PlayerCharacter {

    public Wizard() {
        this.strength = 1;
        this.intellect = 6;
        this.dexterity = 2;
        this.name = "Mago";
        this.spellNames[0] = "Foguinho";
        this.spellNames[1] = "Fogasso";
        this.spellNames[2] = "Águinha";
        this.spellNames[3] = "Águasso";
        this.spellNames[4] = "Apocalipse";
    }

    @Override
    public void defaultAttack() {
        System.err.println(name + " enfeitiçou!");
    }

    @Override
    public final void ability1(EnemyCharacter inimigo) {
        System.err.println(name + " lançou bola de fogo!");
        inimigo.setHealth(
                inimigo.getHealth() - (((this.getIntellect() * 2)
                + (this.getDexterity() * 0.5))) / this.getStrength());

    }

    @Override
    public final void ability2(EnemyCharacter inimigo) {
        System.err.println(name + " lançou bolão de fogo!");
        inimigo.setHealth(
                inimigo.getHealth() - (((this.getIntellect() * 2)
                + (this.getDexterity() * 0.5))));
    }

    @Override
    public final void ability3(EnemyCharacter inimigo) {
        System.err.println(name + " lançou jato d'água!");
        inimigo.setHealth(
                inimigo.getHealth() - (((this.getIntellect() * 3) / this.getStrength())));
    }

    @Override
    public final void ability4(EnemyCharacter inimigo) {
        System.err.println(name + " lançou jatasso d'água!");
        inimigo.setHealth(
                inimigo.getHealth() - (this.getIntellect() * 3));
    }

    @Override
    public final void ability5(EnemyCharacter inimigo) {
        System.err.println(name + " lançou armageddom");
        inimigo.setHealth(-1);
        this.setHealth(this.getHealth()-20);
    }

}
