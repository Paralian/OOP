public class Ranger extends Weapon {
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public <T extends Weapon> void equip(Weapon weapon) {
        if (this.weapon.isTwoHanded() && this.weapon.isRanged())
        this.weapon = weapon;
    }

    @Override
    public boolean isOneHanded() {
        return false;
    }

    @Override
    public boolean isMelee() {
        return false;
    }

    @Override
    public boolean isRanged() {
        return true;
    }
}
