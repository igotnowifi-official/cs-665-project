/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: D6.java
 * Description: Implements DiceStrategy for rolling a 6-sided die.
 */

package edu.bu.met.cs665.dice;

import java.util.Random;
 
/**
 * Implements DiceStrategy for rolling a 6-sided die.
 */
public class D6 implements DiceStrategy {
  private Random random = new Random();
 
  /**
   * Rolls a 6-sided die.
   * @return A random value between 1 and 6.
   */
  @Override
  public int roll() {
    return random.nextInt(6) + 1;
  }
}
 