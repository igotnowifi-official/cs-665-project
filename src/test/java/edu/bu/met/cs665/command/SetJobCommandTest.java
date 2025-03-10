/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: SetJobCommandTest.java
 * Description: Unit test for SetJobCommand class.
 */

package edu.bu.met.cs665.command;

import edu.bu.met.cs665.character.DefaultCharacter;
import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.job.JobFactory;
import edu.bu.met.cs665.race.RaceFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for SetJobCommand class.
 */
public class SetJobCommandTest {
  private GameCharacter character;
  private SetJobCommand setJobCommand;
 
  @Before
  public void setUp() {
    character = new DefaultCharacter("Hero", JobFactory.createJob("fighter"), RaceFactory.createRace("human"));
    setJobCommand = new SetJobCommand(character, "wizard");
  }
 
  /**
   * Tests executing a job change.
   */
  @Test
  public void testExecute() {
    setJobCommand.execute();
    assertEquals("Wizard", character.getJob().getJobName());
  }
}
 