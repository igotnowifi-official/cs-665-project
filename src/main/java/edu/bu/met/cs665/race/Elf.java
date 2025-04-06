package edu.bu.met.cs665.race;

/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Elf.java
 * Description: Predefined Elf race with dexterity bonuses.
 */
public class Elf extends Race {

  /**
   * Type indicator for Gson deserialization.
   * Required by RuntimeTypeAdapterFactory to identify subclass type.
   */
  @SuppressWarnings("unused")
  private final String type = "elf";

  /**
   * Constructor for Elf.
   */
  public Elf() {
    super("Elf", 0, 2, 2);
  }
}
