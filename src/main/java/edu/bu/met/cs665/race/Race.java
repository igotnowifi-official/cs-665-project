/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Race.java
 * Description: Abstract base class for RPG races.
 */

package edu.bu.met.cs665.race;

/**
 * Represents a character's race with stat bonuses.
 */
public abstract class Race {
  protected String raceName;
  protected int strengthBonus;
  protected int dexterityBonus;
  protected int intelligenceBonus;
 
  /**
   * Constructor for Race.
   * @param raceName The name of the race.
   * @param strengthBonus Bonus to strength stat.
   * @param dexterityBonus Bonus to dexterity stat.
   * @param intelligenceBonus Bonus to intelligence stat.
   */
  public Race(String raceName, int strengthBonus, int dexterityBonus, int intelligenceBonus) {
    this.raceName = raceName;
    this.strengthBonus = strengthBonus;
    this.dexterityBonus = dexterityBonus;
    this.intelligenceBonus = intelligenceBonus;
  }
 
  /**
   * Gets the race name.
   * @return The race name.
   */
  public String getRaceName() {
    return raceName;
  }
 
  /**
   * Gets the strength bonus.
   * @return The strength bonus.
   */
  public int getStrengthBonus() {
    return strengthBonus;
  }
 
  /**
   * Gets the dexterity bonus.
   * @return The dexterity bonus.
   */
  public int getDexterityBonus() {
    return dexterityBonus;
  }
 
  /**
   * Gets the intelligence bonus.
   * @return The intelligence bonus.
   */
  public int getIntelligenceBonus() {
    return intelligenceBonus;
  }
}
 