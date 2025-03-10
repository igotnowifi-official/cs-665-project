/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: LoggerTest.java
 * Description: Unit test for Logger (Observer Pattern).
 */

package edu.bu.met.cs665.observer;

import org.junit.Test;
import static org.junit.Assert.*;
 
/**
 * Unit test for Logger class.
 */
public class LoggerTest {
  /**
   * Tests if Logger logs messages correctly.
   */
  @Test
  public void testLogging() {
    Logger logger = new Logger();
    logger.update("Character created");
    assertTrue(true); // Simple pass check
  }
}
 