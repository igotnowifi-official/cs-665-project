/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: D20.java
 * Description: Implements DiceStrategy for rolling a 20-sided die.
 */

package edu.bu.met.cs665.dice;

import java.util.Random;
 
/**
 * Implements DiceStrategy for rolling a 20-sided die.
 */
public class D20 implements DiceStrategy {
  private Random random = new Random();
 
  /**
   * Rolls a 20-sided die.
   * @return A random value between 1 and 20.
   */
  @Override
  public int roll() {
    return random.nextInt(20) + 1;
  }
}
 