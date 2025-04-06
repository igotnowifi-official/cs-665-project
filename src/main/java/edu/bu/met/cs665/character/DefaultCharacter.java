/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DefaultCharacter.java
 * Description: A concrete implementation of GameCharacter used for character creation.
 *              This class is saved as a JSON file under assets/characters/.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;
 
/**
 * Represents a fully initialized game character with race, job, and stats.
 */
public class DefaultCharacter extends GameCharacter {
 
  /**
   * Type indicator required for Gson polymorphic serialization.
   */
  @SuppressWarnings("unused")
  private final String type = "default";
 
  /**
   * Constructs a DefaultCharacter with the given name, job, and race.
   * @param name The name of the character.
   * @param job The selected job class.
   * @param race The selected race.
   */
  public DefaultCharacter(String name, Job job, Race race) {
    super(name, job, race);
  }
 
  /**
   * Prints the full details of the character to the console.
   */
  @Override
  public void displayCharacter() {
    System.out.println("Character: " + name);
    System.out.println("Race: " + (race != null ? race.getRaceName() : "None"));
    System.out.println("Job: " + (job != null ? job.getJobName() : "None"));
    stats.displayStats();
    if (job != null) {
      job.specialAbility();
    }
  }
}