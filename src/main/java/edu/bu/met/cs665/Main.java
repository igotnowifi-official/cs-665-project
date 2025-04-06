/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Main.java
 * Description: Program entry point for RPG Character Creation System.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.character.CharacterFacade;
import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.character.io.CharacterFileIO;
import edu.bu.met.cs665.dice.D20;
import edu.bu.met.cs665.dice.D6;
import edu.bu.met.cs665.job.JobFactory;
import edu.bu.met.cs665.race.RaceFactory;
import java.util.Scanner;

/**
 * Main class to run the RPG Character Creation System.
 */
public class Main {

  /**
   * Main method to start the RPG character creation process.
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Get character name
      System.out.print("Enter character name: ");
      String characterName = scanner.nextLine().trim().toLowerCase();

      // Load from cache if character exists in cache
      GameCharacter existing = CharacterFileIO.load(characterName);
      if (existing != null) {
        System.out.println("Character already exists. Loaded from file:");
        existing.displayCharacter();
        return;
      }

      // Get race 
      System.out.print("Enter race (human, elf, orc, dwarf, or type your custom race): ");
      String raceName = scanner.nextLine().trim().toLowerCase();

      // To create the race, if not found, register custom
      if (raceName.equals("custom") || !RaceFactory.raceExists(raceName)) {
        System.out.print("Race not found. Register as custom? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y") || input.equals("yes")) {
          RaceFactory.registerCustomRaceWithDice(raceName);
        } else {
          System.out.println("Aborting character creation.");
          return;
        }
      }

      // Initialize CharacterFacade (Build Character)
      CharacterFacade facade = CharacterFacade.fromNew(characterName, raceName);
      
      // Get Job
      System.out.print("Enter job (fighter, wizard, rogue, cleric, or type your custom job): ");
      String jobName = scanner.nextLine().trim().toLowerCase();

      // To create the job, if not found, register custom
      if (jobName.equals("custom") || !JobFactory.jobExists(jobName)) {
        System.out.print("Job not found. Register as custom? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y") || input.equals("yes")) {
          System.out.print("Enter custom job ability: ");
          String ability = scanner.nextLine();
          JobFactory.registerCustomJobWithDice(jobName, ability);
        } else {
          System.out.println("Aborting character creation.");
          return;
        }
      }

      facade.setJob(jobName);

      // Roll stats using 
      System.out.println("Rolling stats using D20 + D6 dice...");
      facade.rollStats(new D20(), new D6());

      // Build and display character
      GameCharacter newCharacter = facade.buildCharacter();
      newCharacter.displayCharacter();

      // Save to file
      CharacterFileIO.save(newCharacter);
      
    } finally {
      scanner.close();
    }
  }
}
