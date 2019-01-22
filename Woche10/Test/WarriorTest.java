import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {

    @Test
    public void equip() {
        Warrior warrior = new Warrior();
        Weapon dagger = new Dagger();
        Weapon crossBow = new CrossBow();
        Weapon greatSword = new GreatSword();
        Weapon bow = new Bow();
        Weapon gunLance = new GunLance();

        warrior.equip(dagger);
        assertEquals(dagger, warrior.getWeapon());
        warrior.equip(crossBow);
        assertEquals(crossBow, warrior.getWeapon());
        warrior.equip(greatSword);
        assertEquals(greatSword, warrior.getWeapon());
        warrior.equip(bow);
        assertEquals(bow, warrior.getWeapon());
        warrior.equip(gunLance);
        assertEquals(gunLance, warrior.getWeapon());
    }
}