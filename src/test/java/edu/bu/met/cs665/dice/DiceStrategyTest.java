/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: DiceStrategyTest.java
 * Description: Unit test for DiceStrategy implementations.
 */

package edu.bu.met.cs665.dice;

import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for DiceStrategy implementations.
 */
public class DiceStrategyTest {
  /**
   * Tests rolling a D6 die.
   */
  @Test
  public void testD6Roll() {
    DiceStrategy d6 = new D6();
    int result = d6.roll();
    assertTrue(result >= 1 && result <= 6);
  }
 
  /**
   * Tests rolling a D20 die.
   */
  @Test
  public void testD20Roll() {
    DiceStrategy d20 = new D20();
    int result = d20.roll();
    assertTrue(result >= 1 && result <= 20);
  }
}
 