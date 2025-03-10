/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Observer.java
 * Description: Observer interface for event notifications.
 */

package edu.bu.met.cs665.observer;

/**
 * Defines the Observer pattern for receiving event notifications.
 */
public interface Observer {
  /**
   * Notifies the observer when an event occurs.
   * @param message The event message.
   */
  void update(String message);
}
 