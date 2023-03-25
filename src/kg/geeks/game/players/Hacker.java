package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Hacker extends Hero{
    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.HACK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int numberToTake = RPG_Game.random.nextInt(8) + 10;
        int randomHero = RPG_Game.random.nextInt(heroes.length);
        if(RPG_Game.roundNumber % 2 != 0 && randomHero != 3){
            boss.setHealth(boss.getHealth() - numberToTake);
            heroes[randomHero].setHealth(heroes[randomHero].getHealth() + numberToTake);
            System.out.println("number to take: " + numberToTake);
            System.out.println("random hero index: " + randomHero);
        }
    }
}
