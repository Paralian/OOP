import java.util.ArrayList;
import java.util.List;

public class Lootcrate {
    private List<Weapon> lootCrate;

    Lootcrate(List<Weapon> lootCrate) {
        this.lootCrate = lootCrate;
    }

    public <T extends Weapon> List<T> filter(T weapon) {
        List<T> result = new ArrayList<>();
        for (Weapon loot : lootCrate) {
            if (weapon.getClass().isInstance(loot)) {
                result.add((T) loot);
            }
        }
        return result;
    }
}
