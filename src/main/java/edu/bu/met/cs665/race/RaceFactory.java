/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: RaceFactory.java
 * Description: Factory pattern for predefined and custom races.
 */

package edu.bu.met.cs665.race;

import java.util.HashMap;
import java.util.Map;
 
/**
 * Factory for creating predefined and custom races.
 */
public class RaceFactory {
  private static final Map<String, Race> customRaces = new HashMap<>();
 
  /**
   * Creates a predefined or custom race.
   * @param raceName The name of the race.
   * @return The corresponding Race object.
   */
  public static Race createRace(String raceName) {
    switch (raceName.toLowerCase()) {
      case "human":
        return new Human();
      case "elf":
        return new Elf();
      case "orc":
        return new Orc();
      case "dwarf":
        return new Dwarf();
      default:
        if (customRaces.containsKey(raceName.toLowerCase())) {
          return customRaces.get(raceName.toLowerCase());
        }
        throw new IllegalArgumentException("Invalid race name");
    }
  }
 
  /**
   * Registers a custom race with unique stat bonuses.
   * @param name The name of the custom race.
   * @param strengthBonus The strength bonus.
   * @param dexterityBonus The dexterity bonus.
   * @param intelligenceBonus The intelligence bonus.
   */
  public static void registerCustomRace(
      String name,
      int strengthBonus,
      int dexterityBonus,
      int intelligenceBonus
  ) {
    customRaces.put(
        name.toLowerCase(),
        new CustomRace(
            name,
            strengthBonus,
            dexterityBonus,
            intelligenceBonus
        )
    );
    System.out.println("[LOG]: Custom race '" + name + "' has been registered.");
  }

}
 