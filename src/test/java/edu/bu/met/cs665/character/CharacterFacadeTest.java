/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CharacterFacadeTest.java
 * Description: Unit test for CharacterFacade class.
 */

package edu.bu.met.cs665.character;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for CharacterFacade class.
 */
public class CharacterFacadeTest {
  private CharacterFacade facade;

  @Before
  public void setUp() {
    facade = CharacterFacade.fromNew("Hero", "Human");
  }
 
  /**
   * Tests character creation via CharacterFacade.
   */
  @Test
  public void testCharacterCreation() {
    GameCharacter character = facade.buildCharacter();
    assertNotNull(character);
    assertEquals("Human", character.getRace().getRaceName());
    assertEquals("Fighter", character.getJob().getJobName());
  }
}
 
 