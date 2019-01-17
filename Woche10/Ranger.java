public class Ranger {
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public <T extends Weapon> void equip(T weapon) {
        if (weapon.isTwoHanded() && weapon.isRanged()) {
            this.weapon = weapon;
        }
    }
}
