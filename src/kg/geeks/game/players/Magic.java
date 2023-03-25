package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int numberToAdd = RPG_Game.random.nextInt(4) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if(this != heroes[i]) {
                heroes[i].setDamage(heroes[i].getDamage() + numberToAdd);
            }
        }
    }
}
