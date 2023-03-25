package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Warrior extends Hero {
    private String phrase;

    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(8) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * coefficient);
        this.phrase = "Warrior hits critically: " + this.getDamage() * coefficient;
    }

    @Override
    public String toString() {
        if (this.getHealth() > 0 && this.phrase != null) {
            return super.toString() + " --> " + this.phrase;
        } else {
            return super.toString();
        }
    }
}
