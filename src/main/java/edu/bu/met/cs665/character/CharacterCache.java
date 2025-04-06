/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/28/2025
 * File Name: CharacterCache.java
 * Description: In-memory cache for GameCharacter objects loaded from assets/characters.
 */

package edu.bu.met.cs665.character;

import edu.bu.met.cs665.character.io.CharacterCacheIO;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Caches GameCharacter objects by name for reuse during runtime.
 */
public class CharacterCache {
  private static Map<String, GameCharacter> cache = new HashMap<>();
 
  /**
   * Loads all characters from disk into the in-memory cache.
   */
  public static void loadFromFile() {
    cache = CharacterCacheIO.loadCache();
  }
 
  /**
   * Saves all in-memory characters to individual JSON files.
   */
  public static void saveToFile() {
    CharacterCacheIO.saveCache(cache);
  }
 
  /**
   * Adds or updates a character in the in-memory cache and persists to file.
   * @param name The character name.
   * @param character The character object.
   */
  public static void put(String name, GameCharacter character) {
    cache.put(name.toLowerCase(), character);
    CharacterCacheIO.saveCharacter(name, character);
  }
 
  /**
   * Retrieves a character by name from the cache.
   * @param name The character name.
   * @return The GameCharacter object, or null if not found.
   */
  public static GameCharacter get(String name) {
    return cache.get(name.toLowerCase());
  }
 
  /**
   * Checks if a character exists in the cache.
   * @param name The character name.
   * @return true if the character exists; false otherwise.
   */
  public static boolean exists(String name) {
    return cache.containsKey(name.toLowerCase());
  }
}