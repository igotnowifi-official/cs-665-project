/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CharacterBuilder.java
 * Description: Builder pattern for constructing and modifying characters.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;
 
/**
 * Builder pattern for modifying and constructing characters.
 */
public class CharacterBuilder {
  private GameCharacter character;
 
  /**
   * Constructor for CharacterBuilder.
   * @param character The character instance being built.
   */
  public CharacterBuilder(GameCharacter character) {
    this.character = character;
  }
 
  /**
   * Sets the character's race.
   * @param race The race object.
   * @return The updated CharacterBuilder instance.
   */
  public CharacterBuilder setRace(Race race) {
    character.setRace(race);
    return this;
  }
 
  /**
   * Sets the character's job.
   * @param job The job object.
   * @return The updated CharacterBuilder instance.
   */
  public CharacterBuilder setJob(Job job) {
    character.job = job;
    return this;
  }
 
  /**
   * Rolls the character's stats using a dice strategy.
   * @param dice The dice strategy.
   * @return The updated CharacterBuilder instance.
   */
  public CharacterBuilder rollStats(DiceStrategy dice) {
    character.rollStats(dice);
    return this;
  }
 
  /**
   * Builds and returns the finalized character.
   * @return The built character instance.
   */
  public GameCharacter build() {
    return character;
  }
}
 