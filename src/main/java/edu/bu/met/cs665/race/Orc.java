/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Orc.java
 * Description: Predefined Orc race with strength bonuses.
 */

package edu.bu.met.cs665.race;

/**
 * Represents the Orc race with high strength but lower intelligence.
 */
public class Orc extends Race {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "orc";

  /**
   * Constructor for Orc.
   */
  public Orc() {
    super("Orc", 3, 0, -1);
  }
}
 