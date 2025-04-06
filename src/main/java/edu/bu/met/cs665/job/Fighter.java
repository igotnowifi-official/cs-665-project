/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Fighter.java
 * Description: Fighter subclass with special abilities.
 */

package edu.bu.met.cs665.job;

public class Fighter extends Job {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "fighter";

  /**
   * Constructor for Fighter.
   */
  public Fighter() {
    super("Fighter", 15, 10);
  }

  /**
   * Defines the special ability for Fighter.
   */
  @Override
  public void specialAbility() {
    System.out.println("Special Ability: Power Strike - A powerful physical attack.");
  }
}
