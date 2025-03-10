/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CharacterBuilderTest.java
 * Description: Unit test for CharacterBuilder class.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.JobFactory;
import edu.bu.met.cs665.race.RaceFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for CharacterBuilder class.
 */
public class CharacterBuilderTest {
  private CharacterBuilder builder;
  private GameCharacter character;
 
  @Before
  public void setUp() {
    character = new DefaultCharacter("Hero", JobFactory.createJob("fighter"), RaceFactory.createRace("human"));
    builder = new CharacterBuilder(character);
  }
 
  /**
   * Tests setting a race using CharacterBuilder.
   */
  @Test
  public void testSetRace() {
    builder.setRace(RaceFactory.createRace("elf"));
    assertEquals("Elf", character.getRace().getRaceName());
  }
 
  /**
   * Tests setting a job using CharacterBuilder.
   */
  @Test
  public void testSetJob() {
    builder.setJob(JobFactory.createJob("rogue"));
    assertEquals("Rogue", character.getJob().getJobName());
  }
 
  /**
   * Tests if CharacterBuilder successfully builds a character.
   */
  @Test
  public void testBuildCharacter() {
    GameCharacter builtCharacter = builder.build();
    assertNotNull(builtCharacter);
  }
}
 