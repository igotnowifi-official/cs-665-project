/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/28/2025
 * File Name: CharacterCacheIO.java
 * Description: Handles loading and saving GameCharacter files individually
 *              in the assets/characters folder.
 */

package edu.bu.met.cs665.character.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.util.TypeAdapterUtil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Utility class for saving/loading GameCharacter objects as individual files.
 */
public class CharacterCacheIO {
  private static final String CHARACTER_DIR = "assets/characters";
 
  private static final Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(TypeAdapterUtil.characterAdapter())
      .registerTypeAdapterFactory(TypeAdapterUtil.raceAdapter())
      .registerTypeAdapterFactory(TypeAdapterUtil.jobAdapter())
      .setPrettyPrinting()
      .create();
 
  /**
   * Loads all character JSON files from the assets/characters folder.
   * @return A map of character name (lowercase) to GameCharacter object.
   */
  public static Map<String, GameCharacter> loadCache() {
    Map<String, GameCharacter> loaded = new HashMap<>();
    File folder = new File(CHARACTER_DIR);
    if (!folder.exists()) {
      folder.mkdirs();
      return loaded;
    }
 
    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
    if (files == null) {
      return loaded;
    }
 
    for (File file : files) {
      try (FileReader reader = new FileReader(file)) {
        GameCharacter character = gson.fromJson(reader, GameCharacter.class);
        if (character != null) {
          loaded.put(character.getName().toLowerCase(), character);
        }
      } catch (IOException e) {
        System.err.println("[ERROR]: Failed to read character file: " + file.getName());
      }
    }
 
    return loaded;
  }
 
  /**
   * Saves a single character to a JSON file named after the character.
   * @param name Character name (used as filename).
   * @param character GameCharacter to save.
   */
  public static void saveCharacter(String name, GameCharacter character) {
    File folder = new File(CHARACTER_DIR);
    if (!folder.exists()) {
      folder.mkdirs();
    }
 
    File file = new File(folder, name.toLowerCase() + ".json");
    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(character, writer);
    } catch (IOException e) {
      System.err.println("[ERROR]: Failed to save character " + name + ": " + e.getMessage());
    }
  }
 
  /**
   * Saves all characters to individual files.
   * @param cache Full map of all characters to persist.
   */
  public static void saveCache(Map<String, GameCharacter> cache) {
    for (Map.Entry<String, GameCharacter> entry : cache.entrySet()) {
      saveCharacter(entry.getKey(), entry.getValue());
    }
  }
}