public class GunLance extends Weapon implements TwoHanded{
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
