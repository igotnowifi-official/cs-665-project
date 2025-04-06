/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: JobFactory.java
 * Description: Factory pattern for creating predefined and custom jobs.
 */

package edu.bu.met.cs665.job;

import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.character.io.CharacterCacheIO;
import edu.bu.met.cs665.dice.D20;
import edu.bu.met.cs665.dice.DiceStrategy;
import edu.bu.met.cs665.job.io.JobFileIO;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Factory class to create Job objects, including loading and saving custom jobs.
 */
public class JobFactory {
 
  private static final Map<String, Job> customJobs = JobFileIO.loadAll();
  private static final Map<String, Job> jobCache = new HashMap<>();
 
  /**
   * Creates a predefined or custom job.
   * Checks job cache, registered jobs, and previously saved characters.
   *
   * @param jobName The job name.
   * @return The corresponding Job object.
   */
  public static Job createJob(String jobName) {
    String key = jobName.toLowerCase();
 
    for (GameCharacter character : CharacterCacheIO.loadCache().values()) {
      if (character.getJob().getJobName().equalsIgnoreCase(jobName)) {
        return character.getJob();
      }
    }
 
    if (jobCache.containsKey(key)) {
      return jobCache.get(key);
    }
 
    Job job;
    switch (key) {
      case "fighter":
        job = new Fighter();
        break;
      case "wizard":
        job = new Wizard();
        break;
      case "rogue":
        job = new Rogue();
        break;
      case "cleric":
        job = new Cleric();
        break;
      default:
        if (customJobs.containsKey(key)) {
          job = customJobs.get(key);
          break;
        }
        throw new IllegalArgumentException("Invalid job name: " + jobName);
    }

    jobCache.put(key, job);
    return job;
  }
 
  /**
   * Registers a custom job and saves it to file for future reuse.
   *
   * @param name Job name.
   * @param attackPower Attack power.
   * @param defense Defense value.
   * @param ability Special ability description.
   */
  public static void registerCustomJob(String name, int attackPower, int defense, String ability) {
    CustomJob job = new CustomJob(name, attackPower, defense, ability);
    customJobs.put(name.toLowerCase(), job);
    JobFileIO.save(job);
    System.out.println("[LOG]: Custom job '" + name + "' has been registered and saved.");
  }
 
  /**
   * Registers a custom job using random D20 dice for stats.
   *
   * @param name Job name.
   * @param ability Job special ability.
   */
  public static void registerCustomJobWithDice(String name, String ability) {
    DiceStrategy d20 = new D20();
    int atk = d20.roll();
    int def = d20.roll();
    System.out.println("[LOG]: Rolled job stats → ATK: " + atk + ", DEF: " + def);
    registerCustomJob(name, atk, def, ability);
  }
 
  /**
   * Checks if a job exists either as built-in or as a custom job.
   *
   * @param jobName The job name to check.
   * @return True if the job is known.
   */
  public static boolean jobExists(String jobName) {
    String key = jobName.toLowerCase();
    return key.equals("fighter")
      || key.equals("wizard")
      || key.equals("rogue")
      || key.equals("cleric")
      || customJobs.containsKey(key);
  }
}