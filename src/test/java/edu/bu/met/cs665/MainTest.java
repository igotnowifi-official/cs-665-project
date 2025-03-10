/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/08/2025
 * File Name: MainTest.java
 * Description: Unit test for Main class.
 */

package edu.bu.met.cs665;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
 
/**
 * Unit test for Main class.
 */
public class MainTest {
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final ByteArrayInputStream testInput = new ByteArrayInputStream("Hero\nHuman\nFighter\n".getBytes());
 
  @Before
  public void setUp() {
    System.setOut(new PrintStream(outputStream));
    System.setIn(testInput);
  }
 
  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(System.in);
  }
 
  /**
   * Tests if the Main class correctly runs the character creation process.
   */
  @Test
  public void testMainExecution() {
    Main.main(new String[]{});
    String output = outputStream.toString();
 
    assertTrue(output.contains("Enter character name:"));
    assertTrue(output.contains("Enter race (human, elf, orc, dwarf, or custom):"));
    assertTrue(output.contains("Enter job (fighter, wizard, rogue, cleric, or custom):"));
    assertTrue(output.contains("Rolling stats..."));
    assertTrue(output.contains("Character: Hero"));
    assertTrue(output.contains("Race: Human"));
    assertTrue(output.contains("Job: Fighter"));
  }
}
 