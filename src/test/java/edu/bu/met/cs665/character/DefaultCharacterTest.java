/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DefaultCharacterTest.java
 * Description: Unit test for DefaultCharacter class.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.JobFactory;
import edu.bu.met.cs665.race.RaceFactory;
import org.junit.Before;
import org.junit.Test;
 
import static org.junit.Assert.*;
 
/**
 * Unit test for DefaultCharacter class.
 */
public class DefaultCharacterTest {
 
  private DefaultCharacter character;
 
  @Before
  public void setUp() {
    character = new DefaultCharacter("natasya",
        JobFactory.createJob("goddess"),
        RaceFactory.createRace("titans"));
  }
 
  @Test
  public void testCharacterData() {
    assertEquals("natasya", character.getName().toLowerCase());
    assertEquals("goddess", character.getJob().getJobName().toLowerCase());
    assertEquals("titans", character.getRace().getRaceName().toLowerCase());
  }
 
  @Test
  public void testCharacterJobStats() {
    assertTrue(character.getJob().getAttackPower() > 0);
    assertTrue(character.getJob().getDefense() > 0);
  }
 
  @Test
  public void testCharacterRaceBonuses() {
    assertTrue(character.getRace().getStrengthBonus() > 0);
    assertTrue(character.getRace().getDexterityBonus() > 0);
    assertTrue(character.getRace().getIntelligenceBonus() > 0);
  }
}