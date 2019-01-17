public class Rogue extends Weapon {
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public <T extends Weapon> void equip(Weapon weapon) {
        if (this.weapon.isOneHanded())
        this.weapon = weapon;
    }

    @Override
    public boolean isOneHanded() {
        return true;
    }

    @Override
    public boolean isMelee() {
        return true;
    }

    @Override
    public boolean isRanged() {
        return true;
    }
}
