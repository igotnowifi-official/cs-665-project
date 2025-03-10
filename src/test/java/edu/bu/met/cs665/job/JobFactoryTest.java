/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: JobFactoryTest.java
 * Description: Unit test for JobFactory.
 */

package edu.bu.met.cs665.job;

import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for JobFactory.
 */
public class JobFactoryTest {
  /**
   * Tests if a predefined job is created correctly.
   */
  @Test
  public void testCreatePredefinedJob() {
    Job job = JobFactory.createJob("fighter");
    assertEquals("Fighter", job.getJobName());
  }
 
  /**
   * Tests if a custom job can be registered and created.
   */
  @Test
  public void testCreateCustomJob() {
    JobFactory.registerCustomJob("Assassin", 20, 5, "Stealth Kill");
    Job job = JobFactory.createJob("Assassin");
    assertEquals("Assassin", job.getJobName());
  }
}
 