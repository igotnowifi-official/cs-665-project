/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: RaceFactoryTest.java
 * Description: Unit test for RaceFactory.
 */

package edu.bu.met.cs665.race;

import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for RaceFactory.
 */
public class RaceFactoryTest {
  /**
   * Tests creating a predefined race.
   */
  @Test
  public void testCreatePredefinedRace() {
    Race race = RaceFactory.createRace("elf");
    assertEquals("Elf", race.getRaceName());
  }
 
  /**
   * Tests registering and creating a custom race.
   */
  @Test
  public void testCreateCustomRace() {
    RaceFactory.registerCustomRace("Vampire", 5, 3, 2);
    Race race = RaceFactory.createRace("Vampire");
    assertEquals("Vampire", race.getRaceName());
  }
}
 