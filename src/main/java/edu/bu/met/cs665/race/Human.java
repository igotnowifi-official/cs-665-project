package edu.bu.met.cs665.race;

/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Human.java
 * Description: Predefined Human race with balanced stats.
 */
public class Human extends Race {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "human";

  /**
   * Constructor for Human.
   */
  public Human() {
    super("Human", 1, 1, 1);
  }
}
