import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LootcrateTest {

    @Test
    public void filter() {
        Weapon dagger1 = new Dagger();
        Weapon crossBow1 = new CrossBow();
        Weapon greatSword1 = new GreatSword();
        Weapon dagger2 = new Dagger();
        Weapon crossBow2 = new CrossBow();
        Weapon gunLance = new GunLance();
        Weapon bow1 = new Bow();
        Weapon bow2 = new Bow();
        Weapon bow3 = new Bow();

        List<Weapon> lootCrate = new ArrayList<>();
        lootCrate.add(gunLance);
        lootCrate.add(bow2);
        lootCrate.add(dagger1);
        lootCrate.add(crossBow2);
        lootCrate.add(bow1);
        lootCrate.add(dagger1);
        lootCrate.add(crossBow1);
        lootCrate.add(crossBow2);
        lootCrate.add(greatSword1);
        lootCrate.add(dagger2);
        lootCrate.add(gunLance);
        lootCrate.add(dagger1);
        lootCrate.add(greatSword1);
        lootCrate.add(bow3);

        Lootcrate chest = new Lootcrate(lootCrate);

        assertEquals(Arrays.asList(dagger1, dagger1, dagger2, dagger1) , chest.filter(new Dagger()));
        assertEquals(Arrays.asList(crossBow2, crossBow1, crossBow2), chest.filter(new CrossBow()));
        assertEquals(Arrays.asList(greatSword1, greatSword1), chest.filter(new GreatSword()));
        assertEquals(Arrays.asList(gunLance, gunLance), chest.filter(new GunLance()));
        assertEquals(Arrays.asList(bow2, bow1, bow3), chest.filter(new Bow()));
    }
}