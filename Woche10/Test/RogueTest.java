import org.junit.Test;

import static org.junit.Assert.*;

public class RogueTest {

    @Test
    public void equip() {
        Rogue rogue = new Rogue();
        Weapon dagger = new Dagger();
        Weapon crossBow = new CrossBow();
        Weapon greatSword = new GreatSword();
        Weapon bow = new Bow();
        Weapon gunLance = new GunLance();

        rogue.equip(dagger, greatSword);
        rogue.equip(bow, crossBow);
        rogue.equip(gunLance, crossBow);
        assertNull(rogue.getWeaponOne());
        assertNull(rogue.getWeaponTwo());
        rogue.equip(dagger, crossBow);
        assertEquals(dagger, rogue.getWeaponOne());
        assertEquals(crossBow, rogue.getWeaponTwo());
    }
}