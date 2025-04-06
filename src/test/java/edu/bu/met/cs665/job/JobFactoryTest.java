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
   * Tests loading a custom job from file (assets/jobs/goddess.json).
   */
  @Test
  public void testLoadCustomJobFromFile() {
    Job job = JobFactory.createJob("goddess");
    assertNotNull(job);
    assertEquals("goddess", job.getJobName().toLowerCase());
    assertTrue(job.getAttackPower() > 0);
    assertTrue(job.getDefense() > 0);
  }
}