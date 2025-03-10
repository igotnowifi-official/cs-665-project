/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: StatsTest.java
 * Description: Unit test for Stats class.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.dice.D20;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for Stats class.
 */
public class StatsTest {
  private Stats stats;
 
  @Before
  public void setUp() {
    stats = new Stats();
  }
 
  /**
   * Tests if stats initialize to zero.
   */
  @Test
  public void testStatInitialization() {
    assertEquals(0, stats.getStrength());
    assertEquals(0, stats.getDexterity());
    assertEquals(0, stats.getIntelligence());
  }
 
  /**
   * Tests if stat rolling works within valid dice ranges.
   */
  @Test
  public void testStatRolling() {
    stats.rollStats(new D20());
    assertTrue(stats.getStrength() >= 1 && stats.getStrength() <= 20);
    assertTrue(stats.getDexterity() >= 1 && stats.getDexterity() <= 20);
    assertTrue(stats.getIntelligence() >= 1 && stats.getIntelligence() <= 20);
  }
}
 