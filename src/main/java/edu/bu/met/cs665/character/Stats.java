/**
* Name: Natasya Liew U15913137
* Course: CS-665 Software Designs & Patterns
* Date: 03/08/2025
* File Name: Stats.java
* Description: Represents character stats and handles dice rolling.
*/

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.race.Race;

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
   * Rolls base stats and applies job + race bonuses using separate dice.
   * @param baseDice Dice used for core stat values (e.g., D20)
   * @param bonusDice Dice used for race/job bonuses (e.g., D6)
   * @param race The selected race
   * @param job The selected job
   */
  public void rollStatsWithBonuses(DiceStrategy baseDice, DiceStrategy bonusDice,
        Race race, Job job) {
    this.strength =
        baseDice.roll() + bonusDice.roll() * (race.getStrengthBonus() + job.getAttackPower());
    this.dexterity =
        baseDice.roll() + bonusDice.roll() * (race.getDexterityBonus());
    this.intelligence =
        baseDice.roll() + bonusDice.roll() * (race.getIntelligenceBonus());
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
