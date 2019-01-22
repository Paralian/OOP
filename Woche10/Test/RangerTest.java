import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    @Test
    public void equip() {
        Ranger ranger = new Ranger();
        Weapon dagger = new Dagger();
        Weapon crossBow = new CrossBow();
        Weapon greatSword = new GreatSword();
        Weapon bow = new Bow();
        Weapon gunLance = new GunLance();

        ranger.equip(dagger);
        ranger.equip(greatSword);
        ranger.equip(crossBow);
        assertNull(ranger.getWeapon());
        ranger.equip(bow);
        assertEquals(bow, ranger.getWeapon());
        ranger.equip(gunLance);
        assertEquals(gunLance, ranger.getWeapon());
    }
}