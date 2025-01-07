package polydemo;

import java.util.Scanner;

import polydemo.Classes.*;

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

    public static void enemyEncounter(AppConfig appVars) {
        System.out.println("Você se depara contra um " + appVars.Inimigos.get(appVars.currentEnemy).getName()
                + " o que você fará?");
        while (true) {

            appVars.player.displaySpells(appVars);

            int choice = appVars.scanner.nextInt();
            while (choice < 1 || choice > (appVars.player.getExp() + 10) / 10) {
                choice = appVars.scanner.nextInt();
            }

            switch (choice) {
                case 1 -> {
                    clearScreen();
                    appVars.player.defaultAttack();
                    appVars.Inimigos.get(appVars.currentEnemy).setHealth(
                            appVars.Inimigos.get(appVars.currentEnemy).getHealth() - appVars.player.getStrength());
                }

                case 2 -> {
                    clearScreen();
                    if (appVars.player.getExp() >= 10) {
                        appVars.player.ability1(appVars.Inimigos.get(appVars.currentEnemy));
                    }
                }

                case 3 -> {
                    clearScreen();
                    if (appVars.player.getExp() >= 20) {
                        appVars.player.ability2(appVars.Inimigos.get(appVars.currentEnemy));
                    }
                }

                case 4 -> {
                    clearScreen();
                    if (appVars.player.getExp() >= 30) {
                        appVars.player.ability3(appVars.Inimigos.get(appVars.currentEnemy));
                    }
                }

                case 5 -> {
                    clearScreen();
                    if (appVars.player.getExp() >= 40) {
                        appVars.player.ability4(appVars.Inimigos.get(appVars.currentEnemy));
                    }
                }

                case 6 -> {
                    clearScreen();
                    if (appVars.player.getExp() >= 50) {
                        appVars.player.ability5(appVars.Inimigos.get(appVars.currentEnemy));
                    }
                }

                default -> {
                }
            }

            if (appVars.Inimigos.get(appVars.currentEnemy).getHealth() <= 0) {
                System.out.println(appVars.Inimigos.get(appVars.currentEnemy).getName() + " faleceu.");
                if (appVars.currentEnemy != appVars.Inimigos.size() - 1) {
                    appVars.currentEnemy++;
                } else if (appVars.currentEnemy == appVars.Inimigos.size() - 1) {
                    keepScreen(appVars.scanner);
                    clearScreen();
                    System.out.println("Você venceu.");
                    keepScreen(appVars.scanner);
                    clearScreen();
                }
                appVars.player.setExp(appVars.player.getExp() + 10);
            }

            else {
                appVars.Inimigos.get(appVars.currentEnemy).castSpell(appVars);
            }

            if (appVars.player.getHealth() <= 0) {
                System.out.println(appVars.player.getName() + " faleceu");
                keepScreen(appVars.scanner);
                clearScreen();
                System.out.println("Você perdeu.");
                keepScreen(appVars.scanner);
                clearScreen();
                break;
            }
            keepScreen(appVars.scanner);
            clearScreen();

            if (!appVars.player.effectsApplied.isEmpty()) {
                appVars.player.effectsAppliedTick(appVars);
            }

            System.out.println(appVars.Inimigos.get(appVars.currentEnemy).getName() + " está com; "
                    + appVars.Inimigos.get(appVars.currentEnemy).getHealth() + " de vida");
            System.out.println(appVars.player.getName() + " está com; "
                    + appVars.player.getHealth() + " de vida");
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
        {
            int choice = AppVars.scanner.nextInt();
            while (choice < 0 || choice > 3) {
                choice = AppVars.scanner.nextInt();
            }
            switch (choice) {
                case 1 -> AppVars.player = new Warrior();
                case 2 -> AppVars.player = new Wizard();
                case 3 -> AppVars.player = new Hunter();
                default -> throw new AssertionError();
            }
        }
        keepScreen(AppVars.scanner);
        clearScreen();
        enemyEncounter(AppVars);
    }
}
