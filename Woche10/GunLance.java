public class GunLance extends Weapon implements TwoHanded, Melee, Ranged {
    @Override
    public boolean isMelee() {
        return true;
    }

    @Override
    public boolean isRanged() {
        return true;
    }

    @Override
    public boolean isOneHanded() {
        return false;
    }
}
