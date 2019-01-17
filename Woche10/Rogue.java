public class Rogue {
    private Weapon weaponOne, weaponTwo;

    public Weapon getWeaponOne() {
        return weaponOne;
    }

    public Weapon getWeaponTwo() {
        return weaponTwo;
    }

    public <T extends Weapon> void equip(T weaponOne, T weaponTwo) {
        if (weaponOne.isOneHanded() && weaponTwo.isOneHanded()) {
            this.weaponOne = weaponOne;
            this.weaponTwo = weaponTwo;
        }
    }
}
