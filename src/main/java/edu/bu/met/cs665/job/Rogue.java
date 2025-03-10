/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Rogue.java
 * Description: Rogue subclass with stealth abilities.
 */

package edu.bu.met.cs665.job;

/**
 * Represents the Rogue job class with stealth abilities.
 */
public class Rogue extends Job {
  /**
   * Constructor for Rogue.
   */
  public Rogue() {
    super("Rogue", 12, 8);
  }
 
  /**
   * Defines the special ability for Rogue.
   */
  @Override
  public void specialAbility() {
    System.out.println("Special Ability: Sneak Attack - Deals extra damage when unnoticed.");
  }
}
 