/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: CharacterFileIOTest.java
 * Description: Unit test for loading character JSON files.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.character.io.CharacterFileIO;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for CharacterFileIO class.
 */
public class CharacterFileIOTest {
 
  /**
   * Tests loading the saved character "natasya" from assets/characters/natasya.json.
   */
  @Test
  public void testLoadNatasyaCharacterFromFile() {
    GameCharacter character = CharacterFileIO.load("natasya");
    assertNotNull(character);
    assertEquals("natasya", character.getName().toLowerCase());
 
    // Ensure race and job are also present
    assertNotNull(character.getRace());
    assertNotNull(character.getJob());
    assertEquals("titans", character.getRace().getRaceName().toLowerCase());
    assertEquals("goddess", character.getJob().getJobName().toLowerCase());
  }
}
 