/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Logger.java
 * Description: Logs character creation events.
 */

package edu.bu.met.cs665.observer;

/**
 * Logs events when character attributes are set or changed.
 */
public class Logger implements Observer {
  /**
   * Logs a message when an event occurs.
   * @param message The log message.
   */
  @Override
  public void update(String message) {
    System.out.println("[LOG]: " + message);
  }
}
 