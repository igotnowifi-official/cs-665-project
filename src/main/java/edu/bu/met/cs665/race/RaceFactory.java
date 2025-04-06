/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: RaceFactory.java
 * Description: Factory pattern for predefined and custom races.
 */

package edu.bu.met.cs665.race;

import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.character.io.CharacterCacheIO;
import edu.bu.met.cs665.dice.D6;
import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.race.io.RaceFileIO;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Factory for creating predefined and custom races.
 * Supports loading/saving from assets/races/.
 */
public class RaceFactory {
 
  private static final Map<String, Race> customRaces = RaceFileIO.loadAll();
  private static final Map<String, Race> raceCache = new HashMap<>();
 
  /**
   * Creates a predefined or custom race by name.
   * Reuses races from previously saved characters and loaded custom races.
   * @param raceName The race name.
   * @return A Race instance.
   */
  public static Race createRace(String raceName) {
    String key = raceName.toLowerCase();
 
    // Reuse race from saved characters if available
    for (GameCharacter character : CharacterCacheIO.loadCache().values()) {
      if (character.getRace().getRaceName().equalsIgnoreCase(raceName)) {
        return character.getRace();
      }
    }
 
    if (raceCache.containsKey(key)) {
      return raceCache.get(key);
    }
 
    Race race;
    switch (key) {
      case "human":
        race = new Human();
        break;
      case "elf":
        race = new Elf();
        break;
      case "orc":
        race = new Orc();
        break;
      case "dwarf":
        race = new Dwarf();
        break;
      default:
        if (customRaces.containsKey(key)) {
          race = customRaces.get(key);
          break;
        }
        throw new IllegalArgumentException("Invalid race name: " + raceName);
    }

 
    raceCache.put(key, race);
    return race;
  }
 
  /**
   * Registers a custom race in memory and saves it to disk.
   * @param name Race name.
   * @param strengthBonus Strength stat bonus.
   * @param dexterityBonus Dexterity stat bonus.
   * @param intelligenceBonus Intelligence stat bonus.
   */
  public static void registerCustomRace(
      String name,
      int strengthBonus,
      int dexterityBonus,
      int intelligenceBonus
  ) {
    CustomRace race = new CustomRace(name, strengthBonus, dexterityBonus, intelligenceBonus);
    customRaces.put(name.toLowerCase(), race);
    RaceFileIO.save(race);
    System.out.println("[LOG]: Custom race '" + name + "' has been registered and saved.");
  }
 
  /**
   * Registers a custom race by rolling random bonuses using D6 dice.
   * @param name The custom race name.
    */
  public static void registerCustomRaceWithDice(String name) {
    DiceStrategy d6 = new D6();
    int str = d6.roll();
    int dex = d6.roll();
    int intel = d6.roll();
    System.out.println("[LOG]: Rolled race bonuses → STR: " + str
        + ", DEX: " + dex
        + ", INT: " + intel);

    registerCustomRace(name, str, dex, intel);
  }
 
  /**
   * Checks if a race is either predefined or already registered.
   * @param raceName The race name to check.
   * @return true if it exists.
   */
  public static boolean raceExists(String raceName) {
    String key = raceName.toLowerCase();
    return key.equals("human")
      || key.equals("elf")
      || key.equals("orc")
      || key.equals("dwarf")
      || customRaces.containsKey(key);
  }
}