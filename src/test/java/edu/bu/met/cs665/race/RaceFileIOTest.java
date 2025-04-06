/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: RaceFileIOTest.java
 * Description: Unit test for loading a custom race from JSON.
 */

package edu.bu.met.cs665.race;

import edu.bu.met.cs665.race.io.RaceFileIO;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for RaceFileIO class.
 */
public class RaceFileIOTest {
 
  /**
   * Tests loading the custom race "titans" from assets/races/titans.json.
   */
  @Test
  public void testLoadCustomRaceTitans() {
    Race race = RaceFileIO.loadRace("titans");
    assertNotNull(race);
    assertEquals("titans", race.getRaceName().toLowerCase());
    assertEquals(999999, race.getStrengthBonus());
    assertEquals(999999, race.getDexterityBonus());
    assertEquals(999999, race.getIntelligenceBonus());
  }
}
 