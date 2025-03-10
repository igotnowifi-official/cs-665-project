/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: JobFactory.java
 * Description: Factory pattern for creating predefined and custom jobs.
 */

package edu.bu.met.cs665.job;

import java.util.HashMap;
import java.util.Map;
 
/**
 * Factory for creating predefined and custom jobs dynamically.
 */
public class JobFactory {
  private static final Map<String, Job> customJobs = new HashMap<>();
 
  /**
   * Creates a predefined or custom job.
   * @param jobName The name of the job.
   * @return The corresponding Job object.
   */
  public static Job createJob(String jobName) {
    switch (jobName.toLowerCase()) {
      case "fighter":
        return new Fighter();
      case "wizard":
        return new Wizard();
      case "rogue":
        return new Rogue();
      case "cleric":
        return new Cleric();
      default:
        if (customJobs.containsKey(jobName.toLowerCase())) {
          return customJobs.get(jobName.toLowerCase());
        }
        throw new IllegalArgumentException("Invalid job name");
    }
  }
 
  /**
   * Registers a custom job with unique abilities.
   * @param name The name of the custom job.
   * @param attackPower The attack power.
   * @param defense The defense value.
   * @param ability The special ability description.
   */
  public static void registerCustomJob(String name, int attackPower, int defense, String ability) {
    customJobs.put(name.toLowerCase(), new CustomJob(name, attackPower, defense, ability));
    System.out.println("[LOG]: Custom job '" + name + "' has been registered.");
  }
}
 