/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CustomRace.java
 * Description: Allows users to define custom races dynamically.
 */

package edu.bu.met.cs665.race;

/**
 * Represents a user-defined custom race with stat bonuses.
 */
public class CustomRace extends Race {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "custom";

  /**
   * Constructor for CustomRace.
   * @param name The custom race name.
   * @param strengthBonus Bonus to strength.
   * @param dexterityBonus Bonus to dexterity.
   * @param intelligenceBonus Bonus to intelligence.
   */
  public CustomRace(String name, int strengthBonus, int dexterityBonus, int intelligenceBonus) {
    super(name, strengthBonus, dexterityBonus, intelligenceBonus);
  }
}
 