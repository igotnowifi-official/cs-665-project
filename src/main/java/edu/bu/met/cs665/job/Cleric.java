/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Cleric.java
 * Description: Cleric subclass with special abilities.
 */

package edu.bu.met.cs665.job;

/**
 * Represents the Cleric job class with healing abilities.
 */
public class Cleric extends Job {
  /**
   * Constructor for Cleric.
   */
  public Cleric() {
    super("Cleric", 8, 12);
  }
 
  /**
   * Defines the special ability for Cleric.
   */
  @Override
  public void specialAbility() {
    System.out.println("Special Ability: Heal - Restores health to allies.");
  }
}
 