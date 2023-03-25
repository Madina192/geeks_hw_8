package kg.geeks.game.players;

public class Bomber extends Hero{
    public Bomber(int health, int damage, String name) {
        super(health, damage, SuperAbility.ATTACK_100, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() <= 0 && this != heroes[i]){
                boss.setHealth(boss.getHealth() - 100);
            }
        }
    }
}
