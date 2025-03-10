/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: SetJobCommand.java
 * Description: Command for setting and undoing character job.
 */

package edu.bu.met.cs665.command;

import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.job.JobFactory;
 
/**
 * Command pattern implementation for setting and undoing a character's job.
 */
public class SetJobCommand implements Command {
  private GameCharacter character;
  private Job newJob;
  private Job previousJob;
 
  /**
   * Constructor for SetJobCommand.
   * @param character The character instance.
   * @param jobName The name of the job to be assigned.
   */
  public SetJobCommand(GameCharacter character, String jobName) {
    this.character = character;
    this.newJob = JobFactory.createJob(jobName);
  }
 
  /**
   * Executes the command by setting the new job.
   */
  @Override
  public void execute() {
    previousJob = character.getJob();
    character.setJob(newJob);
  }
 
  /**
   * Undoes the command by reverting to the previous job.
   */
  @Override
  public void undo() {
    character.setJob(previousJob);
  }
}
 