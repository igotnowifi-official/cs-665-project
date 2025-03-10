/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DiceStrategy.java
 * Description: Strategy pattern for different dice rolling mechanisms.
 */

package edu.bu.met.cs665.dice;

/**
 * Represents a strategy for rolling dice.
 */
public interface DiceStrategy {
  /**
   * Rolls the dice and returns the result.
   * @return The value rolled.
   */
  int roll();
}
 