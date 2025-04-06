/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Wizard.java
 * Description: Wizard subclass with special abilities.
 */

package edu.bu.met.cs665.job;

/**
 * Represents the Wizard job class with unique abilities.
 */
public class Wizard extends Job {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "wizard";

  /**
   * Constructor for Wizard.
   */
  public Wizard() {
    super("Wizard", 10, 5);
  }
 
  /**
   * Defines the special ability for Wizard.
   */
  @Override
  public void specialAbility() {
    System.out.println("Special Ability: Cast Spell - A devastating magic attack.");
  }
}
 