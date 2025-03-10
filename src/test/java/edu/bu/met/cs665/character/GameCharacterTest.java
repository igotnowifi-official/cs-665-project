/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: GameCharacterTest.java
 * Description: Unit test for GameCharacter class.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.Fighter;
import edu.bu.met.cs665.race.Human;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for GameCharacter class.
 */
public class GameCharacterTest {
  private GameCharacter character;
 
  @Before
  public void setUp() {
    character = new DefaultCharacter("Hero", new Fighter(), new Human());
  }
 
  /**
   * Tests if the character is created successfully with the correct attributes.
   */
  @Test
  public void testCharacterCreation() {
    assertNotNull(character);
    assertEquals("Hero", character.getName());
    assertEquals("Fighter", character.getJob().getJobName());
    assertEquals("Human", character.getRace().getRaceName());
  }
}
 