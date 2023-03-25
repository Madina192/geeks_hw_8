package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Samurai extends Hero{
    public Samurai(int health, int damage, String name) {
        super(health, damage, SuperAbility.SHURIKEN, name);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean isItVirus = RPG_Game.random.nextBoolean();
        if(isItVirus){
            this.setDamage(10);
            System.out.println("Samurai attacked");
        } else{
            boss.setHealth(boss.getHealth() + 10);
            System.out.println("Samurai healed Boss");
        }
    }
}
