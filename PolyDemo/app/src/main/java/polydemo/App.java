package polydemo;

import java.util.Scanner;

import polydemo.Character.*;

public class App {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void keepScreen(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Pressione enter para prosseguir;");
        scanner.nextLine();
    }

    public static void enemyEncounter(AppConfig AppVars) {
        System.out.println("Você se depara contra um " + AppVars.Inimigos.get(AppVars.currentEnemy).getName()
                + " o que você fará?");
        while (true) {
            switch (AppVars.classe.displaySpells(AppVars)) {
                case 1:
                    clearScreen();
                    AppVars.classe.defaultAttack();
                    AppVars.Inimigos.get(AppVars.currentEnemy).setHealth(
                            AppVars.Inimigos.get(AppVars.currentEnemy).getHealth() - AppVars.classe.getStrength());
                    break;

                case 2:
                    clearScreen();
                    if (AppVars.classe.getExp() >= 10) {
                        AppVars.classe.ability1(AppVars.Inimigos.get(AppVars.currentEnemy));
                    }

                    break;

                case 3:
                    clearScreen();
                    if (AppVars.classe.getExp() >= 20) {
                        AppVars.classe.ability2(AppVars.Inimigos.get(AppVars.currentEnemy));
                    }

                    break;

                case 4:
                    clearScreen();
                    if (AppVars.classe.getExp() >= 30) {
                        AppVars.classe.ability3(AppVars.Inimigos.get(AppVars.currentEnemy));
                    }
                    break;

                case 5:
                    clearScreen();
                    if (AppVars.classe.getExp() >= 40) {
                        AppVars.classe.ability4(AppVars.Inimigos.get(AppVars.currentEnemy));
                    }
                    break;

                case 6:
                    clearScreen();
                    if (AppVars.classe.getExp() >= 50) {
                        AppVars.classe.ability5(AppVars.Inimigos.get(AppVars.currentEnemy));
                    }
                    break;

                default:
                    break;
            }

            if (AppVars.Inimigos.get(AppVars.currentEnemy).getHealth() <= 0) {
                System.out.println(AppVars.Inimigos.get(AppVars.currentEnemy).getName() + " Faleceu.");
                AppVars.currentEnemy++;
                AppVars.classe.setExp(AppVars.classe.getExp() + 10);
            }

            keepScreen(AppVars.scanner);
            clearScreen();

            System.out.println(AppVars.Inimigos.get(AppVars.currentEnemy).getName() + " está com; "
                    + AppVars.Inimigos.get(AppVars.currentEnemy).getHealth() + " de vida");
            System.out.println("O que você fará?");
        }
    }

    public static void main(String[] args) {

        AppConfig AppVars = new AppConfig();

        clearScreen();
        System.out.println("Qual sua classe");
        System.out.println("(1) - Guerreiro;");
        System.out.println("(2) - Mago;");
        System.out.println("(3) - Caçador;");

        switch (AppVars.scanner.nextInt()) {
            case 1:
                AppVars.classe = new Warrior();
                break;
            case 2:
                AppVars.classe = new Wizard();
                break;
            case 3:
                AppVars.classe = new Hunter();
                break;
            default:
                break;
        }
        keepScreen(AppVars.scanner);
        clearScreen();
        enemyEncounter(AppVars);
    }
}
