/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: CustomJob.java
 * Description: Allows users to define custom job classes dynamically.
 */

package edu.bu.met.cs665.job;

/**
 * Represents a user-defined custom job with a special ability.
 */
public class CustomJob extends Job {
  private String ability;
 
  /**
   * Constructor for CustomJob.
   * @param name The name of the job.
   * @param attackPower The attack power of the job.
   * @param defense The defense value of the job.
   * @param ability The special ability description.
   */
  public CustomJob(String name, int attackPower, int defense, String ability) {
    super(name, attackPower, defense);
    this.ability = ability;
  }
 
  /**
   * Defines the special ability for the custom job.
   */
  @Override
  public void specialAbility() {
    System.out.println("Special Ability: " + ability);
  }
}
 