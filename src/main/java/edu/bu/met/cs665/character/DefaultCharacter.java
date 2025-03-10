/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DefaultCharacter.java
 * Description: A concrete implementation of GameCharacter with default attributes.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;
 
/**
 * Represents a concrete implementation of GameCharacter with default attributes.
 */
public class DefaultCharacter extends GameCharacter {
  /**
   * Constructor for DefaultCharacter with custom name, job, and race.
   * @param name The character's name.
   * @param job The character's job.
   * @param race The character's race.
   */
  public DefaultCharacter(String name, Job job, Race race) {
    super(name, job, race); 
  }
 
  /**
   * Constructor for DefaultCharacter with predefined name, job, and race.
   */
  public DefaultCharacter() {
    super("Natasya", new Job("Goddess", 999, 999) {
      @Override
      public void specialAbility() {
        System.out.println("Special Ability: Divine Judgment - Unleashes godly power.");
      }
    }, new Race("Titans", 100, 100, 100) {});
  }
 
  /**
   * Displays the character's details.
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
 