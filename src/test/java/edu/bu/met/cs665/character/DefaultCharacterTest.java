/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DefaultCharacterTest.java
 * Description: Unit test for DefaultCharacter class.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for DefaultCharacter class.
 */
public class DefaultCharacterTest {
  private DefaultCharacter defaultCharacter;
 
  @Before
  public void setUp() {
    defaultCharacter = new DefaultCharacter();
  }
 
  /**
   * Tests if DefaultCharacter is initialized with correct default attributes.
   */
  @Test
  public void testDefaultCharacterInitialization() {
    assertNotNull(defaultCharacter);
    assertEquals("Natasya", defaultCharacter.getName());
    assertEquals("Goddess", defaultCharacter.getJob().getJobName());
    assertEquals("Titans", defaultCharacter.getRace().getRaceName());
  }
 
  /**
   * Tests if DefaultCharacter's job has the correct attack power and defense values.
   */
  @Test
  public void testDefaultCharacterJobAttributes() {
    Job job = defaultCharacter.getJob();
    assertEquals(999, job.getAttackPower());
    assertEquals(999, job.getDefense());
  }
 
  /**
   * Tests if DefaultCharacter's race provides the correct stat bonuses.
   */
  @Test
  public void testDefaultCharacterRaceBonuses() {
    Race race = defaultCharacter.getRace();
    assertEquals(100, race.getStrengthBonus());
    assertEquals(100, race.getDexterityBonus());
    assertEquals(100, race.getIntelligenceBonus());
  }
}
 