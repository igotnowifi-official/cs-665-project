/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: CharacterFileIO.java
 * Description: Utility class for reading and writing individual character JSON files
 *              from the 'assets/characters/' directory.
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
 
/**
 * Provides static methods to load or save a single GameCharacter from/to JSON files
 * in the 'assets/characters/' directory.
 */
public class CharacterFileIO {
 
  private static final String CHAR_FOLDER = "assets/characters/";
 
  private static final Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(TypeAdapterUtil.characterAdapter())
      .registerTypeAdapterFactory(TypeAdapterUtil.raceAdapter())       
      .registerTypeAdapterFactory(TypeAdapterUtil.jobAdapter())
      .setPrettyPrinting()
      .create();
 
  /**
   * Saves a character object to a JSON file named after the character.
   * @param character The character to save.
   */
  public static void save(GameCharacter character) {
    String filename = CHAR_FOLDER + character.getName().toLowerCase() + ".json";
    File file = new File(filename);
    file.getParentFile().mkdirs();
 
    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(character, writer);
    } catch (IOException e) {
      System.err.println("[ERROR]: Failed to save character: " + e.getMessage());
    }
  }
 
  /**
   * Loads a character from a JSON file by name.
   * @param name The name of the character (filename without .json).
   * @return The GameCharacter instance, or null if loading failed.
   */
  public static GameCharacter load(String name) {
    String filename = CHAR_FOLDER + name.toLowerCase() + ".json";
    File file = new File(filename);
    if (!file.exists()) {
      return null;
    }
 
    try (FileReader reader = new FileReader(file)) {
      return gson.fromJson(reader, GameCharacter.class);
    } catch (IOException e) {
      System.err.println("[ERROR]: Failed to load character: " + e.getMessage());
      return null;
    }
  }
}
 