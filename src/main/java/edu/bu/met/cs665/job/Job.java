/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: Job.java
 * Description: Abstract class for RPG jobs.
 */

package edu.bu.met.cs665.job;

/**
 * Represents an abstract base class for different job types.
 */
public abstract class Job {
  protected String jobName;
  protected int attackPower;
  protected int defense;
 
  /**
   * Constructor for Job.
   * @param jobName The name of the job.
   * @param attackPower The attack power of the job.
   * @param defense The defense value of the job.
   */
  public Job(String jobName, int attackPower, int defense) {
    this.jobName = jobName;
    this.attackPower = attackPower;
    this.defense = defense;
  }
 
  /**
   * Gets the job name.
   * @return The job name.
   */
  public String getJobName() {
    return jobName;
  }
 
  /**
   * Gets the attack power of the job.
   * @return The attack power value.
   */
  public int getAttackPower() {
    return attackPower;
  }
 
  /**
   * Gets the defense value of the job.
   * @return The defense value.
   */
  public int getDefense() {
    return defense;
  }
 
  /**
   * Defines a special ability for the job.
   */
  public abstract void specialAbility();
}
 