public class Rogue {
    private Weapon weaponOne, weaponTwo;

    public Weapon getWeaponOne() {
        return weaponOne;
    }

    public Weapon getWeaponTwo() {
        return weaponTwo;
    }

    //TODO s. Ranger
    // die richtige Signatur wäre hier:
    // public <T extends Weapon & OneHanded, U extends Weapon & OneHanded> void equip(T w1, U w2) { ... }
    public <T extends Weapon> void equip(T weaponOne, T weaponTwo) {
        if (weaponOne.isOneHanded() && weaponTwo.isOneHanded()) {
            this.weaponOne = weaponOne;
            this.weaponTwo = weaponTwo;
        }
    }
}
