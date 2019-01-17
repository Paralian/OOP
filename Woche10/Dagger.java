public class Dagger extends Weapon implements Melee{
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
        return false;
    }
}
