public class Warrior {
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public <T extends Weapon> void equip(T weapon) {
        this.weapon = weapon;
    }
}
