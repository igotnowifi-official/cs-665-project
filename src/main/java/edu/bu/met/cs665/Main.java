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
import edu.bu.met.cs665.dice.D20;
import java.util.Scanner;

/**
 * Main class to run the RPG Character Creation System.
 */
public class Main {

  /**
   * Main method to start the RPG character creation process.
   * @param args Command-line arguments (not used in this implementation).
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Get character name
      System.out.print("Enter character name: ");
      String characterName = scanner.nextLine();

      // Get race
      System.out.print("Enter race (human, elf, orc, dwarf, or custom): ");
      String raceName = scanner.nextLine();

      // Initialize CharacterFacade with Race
      CharacterFacade facade = new CharacterFacade(characterName, raceName);

      // Set Job
      System.out.print("Enter job (fighter, wizard, rogue, cleric, or custom): ");
      String jobName = scanner.nextLine();
      facade.setJob(jobName);

      // Roll Stats
      System.out.println("Rolling stats...");
      facade.rollStats(new D20());

      // Build and display character
      GameCharacter myCharacter = facade.buildCharacter();
      myCharacter.displayCharacter();
    } finally {
      scanner.close();
    }
  }
}
