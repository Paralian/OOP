public class Ranger {
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    //TODO wieso macht ihr das mit den isXXX Methoden? Eigentlich solltet ihr das generisch implementieren. -1
    // Dazu wäre die Methodensignatur:
    // public <T extends Weapon & TwoHanded & Ranged> void equip(T weapon) {... }
    public <T extends Weapon> void equip(T weapon) {
        if (weapon.isTwoHanded() && weapon.isRanged()) {
            this.weapon = weapon;
        }
    }
}
