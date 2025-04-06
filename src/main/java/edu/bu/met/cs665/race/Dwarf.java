/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Dwarf.java
 * Description: Predefined Dwarf race with high durability.
 */

package edu.bu.met.cs665.race;

/**
 * Represents the Dwarf race with increased defense and endurance.
 */
public class Dwarf extends Race {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "dwarf";

  /**
   * Constructor for Dwarf.
   */
  public Dwarf() {
    super("Dwarf", 2, 0, 1);
  }
}
 