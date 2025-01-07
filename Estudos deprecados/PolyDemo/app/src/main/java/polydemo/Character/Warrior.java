package polydemo.Character;

import polydemo.Enemies.EnemyCharacter;

public final class Warrior extends PlayerCharacter {

    public Warrior() {
        this.strength = 5;
        this.intellect = 0;
        this.dexterity = 4;
        this.name = "Guerreiro";
        this.spellNames[0] = "Porrada";
        this.spellNames[1] = "Porrada violenta";
        this.spellNames[2] = "Porrada foda";
        this.spellNames[3] = "Porrada enlouquecida";
        this.spellNames[4] = "Porrada da hora";
    }

    @Override
    public void defaultAttack() {
        System.err.println(name + " socou");
    }

    @Override
    public final void ability1(EnemyCharacter inimigo) {
        System.err.println(name + " desferiu porrada!");
        inimigo.setHealth(
                inimigo.getHealth() - ((this.getStrength() * 1.5)
                + (this.getDexterity() * 0.5)));
    }

    @Override
    public final void ability2(EnemyCharacter inimigo) {
        System.err.println(name + " desferiu porrada violenta!");
        inimigo.setHealth(
                inimigo.getHealth() - ((this.getStrength() * 2.5)
                + (this.getDexterity() * 0.5)));
    }

    @Override
    public final void ability3(EnemyCharacter inimigo) {
        System.err.println(name + " desferiu porrada foda!");
        inimigo.setHealth(
                inimigo.getHealth() - ((this.getStrength() * 2)
                + (this.getDexterity() * 2)));
    }

    @Override
    public final void ability4(EnemyCharacter inimigo) {
        System.err.println(name + " desferiu porrada enlouquecida!");
        inimigo.setHealth(
                inimigo.getHealth() - ((this.getStrength() * 0.5)
                + (this.getDexterity() * 5)));
    }

    @Override
    public final void ability5(EnemyCharacter inimigo) {
        System.err.println(name + " desferiu porrada da hora!");
        inimigo.setHealth(
                inimigo.getHealth() - ((this.getStrength() * 3)
                + (this.getDexterity() * 3)));
    }

}
