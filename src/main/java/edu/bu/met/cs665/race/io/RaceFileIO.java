/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: RaceFileIO.java
 * Description: Utility class for saving and loading individual custom Race objects
 *              to and from the assets/races/ folder using Gson.
 */

package edu.bu.met.cs665.race.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.bu.met.cs665.race.Race;
import edu.bu.met.cs665.util.TypeAdapterUtil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Provides static methods for saving and loading custom races to/from JSON files.
 */
public class RaceFileIO {
  private static final String RACE_DIR = "assets/races/";
 
  private static final Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(TypeAdapterUtil.raceAdapter())
      .setPrettyPrinting()
      .create();
 
  /**
   * Saves a single custom race as a JSON file using the race name.
   * @param race The custom race object to save.
   */
  public static void save(Race race) {
    File file = new File(RACE_DIR + race.getRaceName().toLowerCase() + ".json");
    file.getParentFile().mkdirs();
    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(race, writer);
    } catch (IOException e) {
      System.err.println("[ERROR]: Failed to save race "
          + race.getRaceName() + ": " + e.getMessage());
    }
  }
 
  /**
   * Loads all race JSON files from the race folder and returns a map of race name to Race object.
   * @return A map of race name (lowercased) to Race object.
   */
  public static Map<String, Race> loadAll() {
    Map<String, Race> races = new HashMap<>();
    File folder = new File(RACE_DIR);
    if (!folder.exists()) {
      folder.mkdirs();
    }

    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
    if (files == null) {
      return races;
    }
 
    for (File file : files) {
      try (FileReader reader = new FileReader(file)) {
        Race race = gson.fromJson(reader, Race.class);
        if (race != null) {
          races.put(race.getRaceName().toLowerCase(), race);
        }
      } catch (IOException e) {
        System.err.println("[ERROR]: Failed to load race from file " + file.getName());
      }
    }
 
    return races;
  }

  /**
   * Loads a single race from a JSON file given its name.
   * @param raceName The name of the race (filename without .json).
   * @return The Race instance loaded from file.
   * @throws RuntimeException if the file cannot be read.
   */
  public static Race loadRace(String raceName) {
    try {
      String filePath = "assets/races/" + raceName + ".json";
      return gson.fromJson(new FileReader(filePath), Race.class);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load race: " + raceName, e);
    }
  }
}
 