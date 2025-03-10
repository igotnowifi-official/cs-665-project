/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: SetRaceCommand.java
 * Description: Command for setting and undoing character race.
 */

package edu.bu.met.cs665.command;

import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.race.Race;
 
/**
 * Command pattern for setting and undoing character race.
 */
public class SetRaceCommand implements Command {
  private GameCharacter character;
  private Race newRace;
  private Race previousRace;
 
  /**
   * Constructor for SetRaceCommand.
   * @param character The character instance.
   * @param race The new race to be set.
   */
  public SetRaceCommand(GameCharacter character, Race race) {
    this.character = character;
    this.newRace = race;
  }
 
  /**
   * Executes the command by setting the new race.
   */
  @Override
  public void execute() {
    previousRace = character.getRace();
    character.setRace(newRace);
  }
 
  /**
   * Undoes the command by reverting to the previous race.
   */
  @Override
  public void undo() {
    character.setRace(previousRace);
  }
}
 