/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: SetRaceCommandTest.java
 * Description: Unit test for SetRaceCommand class.
 */

package edu.bu.met.cs665.command;

import edu.bu.met.cs665.character.DefaultCharacter;
import edu.bu.met.cs665.job.Fighter;
import edu.bu.met.cs665.race.Elf;
import edu.bu.met.cs665.race.Human;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for SetRaceCommand class.
 */
public class SetRaceCommandTest {
  private DefaultCharacter character;
  private SetRaceCommand setRaceCommand;
 
  @Before
  public void setUp() {
    character = new DefaultCharacter("Hero", new Fighter(), new Human());
    setRaceCommand = new SetRaceCommand(character, new Elf());
  }
 
  /**
   * Tests executing a race change.
   */
  @Test
  public void testExecute() {
    setRaceCommand.execute();
    assertEquals("Elf", character.getRace().getRaceName());
  }
 
  /**
   * Tests undoing a race change.
   */
  @Test
  public void testUndo() {
    setRaceCommand.execute();
    setRaceCommand.undo();
    assertEquals("Human", character.getRace().getRaceName());
  }
}
 