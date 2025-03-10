/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Command.java
 * Description: Command pattern interface for executing and undoing actions.
 */

package edu.bu.met.cs665.command;

/**
 * Represents a command that can be executed and undone.
 */
public interface Command {
  /**
   * Executes the command.
   */
  void execute();
 
  /**
   * Undoes the command.
   */
  void undo();
}
 