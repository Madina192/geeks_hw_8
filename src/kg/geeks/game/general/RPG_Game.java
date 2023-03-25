package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static int roundNumber;

    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1800, 50, "Evil");
        Warrior warrior = new Warrior(270, 10, "Ahiles");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Berserk berserk = new Berserk(290, 15, "Takashi");
        Hacker hacker = new Hacker(260, 10,  "Hacker");
        Samurai samurai = new Samurai(280, 0,  "Samurai");
        Bomber bomber = new Bomber(350, 5,  "Bomber");
        Medic assistant = new Medic(250, 5, 5, "Strange");
        Magic magic = new Magic(240, 20, "Handel");
        Hero[] heroes = {warrior, doc, berserk, hacker, samurai, bomber, assistant, magic};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility() &&
                    heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
