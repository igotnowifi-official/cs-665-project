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
   * Constructor for CharacterFacade.
   * @param characterName The name of the character.
   * @param raceName The race of the character.
   */
  public CharacterFacade(String characterName, String raceName) {
    Race race = RaceFactory.createRace(raceName);
    this.builder = new CharacterBuilder(
      new DefaultCharacter(
        characterName,
        JobFactory.createJob("fighter"),
        race
      )
);
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
   * Rolls stats for the character using a dice strategy.
   * @param dice The dice strategy.
   */
  public void rollStats(DiceStrategy dice) {
    builder.rollStats(dice);
    logger.update("Stats rolled using: " + dice.getClass().getSimpleName());
  }
 
  /**
   * Builds and returns the finalized character.
   * @return The built character.
   */
  public GameCharacter buildCharacter() {
    return builder.build();
  }
}
 