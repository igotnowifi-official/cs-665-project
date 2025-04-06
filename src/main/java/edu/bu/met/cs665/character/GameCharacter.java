/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: GameCharacter.java
 * Description: Abstract base class for RPG characters.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;
 
/**
 * Abstract class representing a game character composed of a race, job, and stats.
 */
public abstract class GameCharacter {
  protected String name;
  protected Race race;
  protected Job job;
  protected Stats stats;
 
  /**
   * Constructor for a game character.
   * @param name The character's name.
   * @param job The character's job.
   * @param race The character's race.
   */
  public GameCharacter(String name, Job job, Race race) {
    this.name = name;
    this.job = job;
    this.race = race;
    this.stats = new Stats();
  }
 
  /**
   * Gets the character's name.
   * @return The character's name.
   */
  public String getName() {
    return name;
  }
 
  /**
   * Gets the character's race.
   * @return The character's race.
   */
  public Race getRace() {
    return race;
  }
 
  /**
   * Sets the character's race and applies race bonuses.
   * @param race The race object.
   */
  public void setRace(Race race) {
    this.race = race;
  }
 
  /**
   * Gets the character's job.
   * @return The character's job.
   */
  public Job getJob() {
    return job;
  }
 
  /**
   * Sets the character's job.
   * @param job The job object.
   */
  public void setJob(Job job) {
    this.job = job;
  }
 
  /**
   * Rolls stats using a dice strategy.
   * @param dice The dice strategy.
   */
  public void rollStats(DiceStrategy dice) {
    stats.rollStats(dice);
  }

  /**
   * Rolls base stats and applies race/job bonuses using separate dice strategies.
   * @param baseDice Dice for core stat values (e.g., D20)
   * @param bonusDice Dice for bonus modifiers (e.g., D6)
   */
  public void rollStatsWithBonuses(DiceStrategy baseDice, DiceStrategy bonusDice) {
    stats.rollStatsWithBonuses(baseDice, bonusDice, race, job);
  }

  /**
   * Displays the character's details.
   */
  public abstract void displayCharacter();
}
 