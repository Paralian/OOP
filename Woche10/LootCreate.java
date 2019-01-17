import java.util.ArrayList;
import java.util.List;

public class LootCreate {
    private List<Weapon> weapons;

    public LootCreate(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public <T extends Weapon> List<T> filter(T weapon) {
        List<T> weaponTemp = new ArrayList<>();
        for (Weapon weaponLoot : weapons) {
            if (weapon.getClass().isInstance(weaponLoot))
            weaponTemp.add((T) weaponLoot);
        }
        return weaponTemp;
    }
}
