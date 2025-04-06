/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CharacterFacade.java
 * Description: Facade to simplify character creation.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.command.SetJobCommand;
import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.job.JobFactory;
import edu.bu.met.cs665.observer.Logger;
import edu.bu.met.cs665.race.Race;
import edu.bu.met.cs665.race.RaceFactory;
 
/**
 * Facade pattern to simplify the character creation process.
 */
public class CharacterFacade {
  private CharacterBuilder builder;
  private Logger logger = new Logger();
  private SetJobCommand setJobCommand;

  /**
   * Constructor to wrap an existing character.
   * @param character An existing GameCharacter (e.g., from cache).
   */
  public CharacterFacade(GameCharacter character) {
    this.builder = new CharacterBuilder(character);
  }
 
  /**
   * Creates a new CharacterFacade with default job and selected race.
   * @param name The name of the character.
   * @param raceName The race name.
   * @return A new CharacterFacade instance.
   */
  public static CharacterFacade fromNew(String name, String raceName) {
    Race race = RaceFactory.createRace(raceName);
    Job defaultJob = JobFactory.createJob("fighter");
    GameCharacter character = new DefaultCharacter(name, defaultJob, race);
    return new CharacterFacade(character);
  }
 
  /**
   * Sets the job for the character using a command.
   * @param jobName The job name.
   */
  public void setJob(String jobName) {
    setJobCommand = new SetJobCommand(builder.build(), jobName);
    setJobCommand.execute();
    logger.update("Job set to: " + jobName);
  }
 
  /**
   * Rolls stats using separate base and bonus dice strategies.
   * @param baseDice Dice for core stat values (e.g., D20)
   * @param bonusDice Dice for bonus modifiers (e.g., D6)
   */
  public void rollStats(DiceStrategy baseDice, DiceStrategy bonusDice) {
    GameCharacter character = builder.build();
    character.rollStatsWithBonuses(baseDice, bonusDice);
    logger.update("Stats rolled with D20 + D6 bonus from race/job");
  }
 
  /**
   * Builds and returns the finalized character.
   * @return The built character.
   */
  public GameCharacter buildCharacter() {
    return builder.build();
  }
}
 