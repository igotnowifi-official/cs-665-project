/**
* Name: Natasya Liew U15913137
* Course: CS-665 Software Designs & Patterns
* Date: 03/08/2025
* File Name: Stats.java
* Description: Represents character stats and handles dice rolling.
*/

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.dice.DiceStrategy;

/**
* Represents a character's stats including strength, dexterity, and intelligence.
*/
public class Stats {
  private int strength;
  private int dexterity;
  private int intelligence;

  /**
   * Default constructor initializes stats to zero.
   */
  public Stats() {
    this.strength = 0;
    this.dexterity = 0;
    this.intelligence = 0;
  }

  /**
   * Rolls stats using a given dice strategy.
   * @param dice The dice strategy used for rolling stats.
   */
  public void rollStats(DiceStrategy dice) {
    this.strength = dice.roll();
    this.dexterity = dice.roll();
    this.intelligence = dice.roll();
  }

  /**
   * Increases stats by the specified bonuses.
   * @param strengthBonus Bonus to strength.
   * @param dexterityBonus Bonus to dexterity.
   * @param intelligenceBonus Bonus to intelligence.
   */
  public void applyBonuses(int strengthBonus, int dexterityBonus, int intelligenceBonus) {
    this.strength += strengthBonus;
    this.dexterity += dexterityBonus;
    this.intelligence += intelligenceBonus;
  }

  /**
   * Displays the character's stats.
   */
  public void displayStats() {
    System.out.println(
          "Stats -> Strength: " + strength
          + ", Dexterity: " + dexterity
          + ", Intelligence: " + intelligence
    );
  }

  /**
   * Gets the strength stat.
   * @return The strength value.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Gets the dexterity stat.
   * @return The dexterity value.
   */
  public int getDexterity() {
    return dexterity;
  }

  /**
   * Gets the intelligence stat.
   * @return The intelligence value.
   */
  public int getIntelligence() {
    return intelligence;
  }
}
