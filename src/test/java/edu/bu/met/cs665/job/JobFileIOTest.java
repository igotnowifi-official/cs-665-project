/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: JobFileIOTest.java
 * Description: Unit test for loading a custom job from JSON.
 */

package edu.bu.met.cs665.job;

import edu.bu.met.cs665.job.io.JobFileIO;
import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for JobFileIO class.
 */
public class JobFileIOTest {
 
  /**
   * Tests loading the custom job "goddess" from assets/jobs/goddess.json.
   */
  @Test
  public void testLoadCustomJobGoddess() {
    Job job = JobFileIO.load("goddess");
    assertNotNull(job);
    assertEquals("goddess", job.getJobName().toLowerCase());
    assertEquals(9999999, job.getAttackPower());
    assertEquals(9999999, job.getDefense());
  }
}
 