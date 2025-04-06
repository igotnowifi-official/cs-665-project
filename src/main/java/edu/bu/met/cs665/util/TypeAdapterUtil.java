/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/28/2025
 * File Name: TypeAdapterUtil.java
 * Description: Provides registered RuntimeTypeAdapterFactory instances for Gson
 *              to enable serialization and deserialization of subclassed objects.
 */

package edu.bu.met.cs665.util;

import edu.bu.met.cs665.character.DefaultCharacter;
import edu.bu.met.cs665.character.GameCharacter;
import edu.bu.met.cs665.job.Cleric;
import edu.bu.met.cs665.job.CustomJob;
import edu.bu.met.cs665.job.Fighter;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.job.Rogue;
import edu.bu.met.cs665.job.Wizard;
import edu.bu.met.cs665.race.CustomRace;
import edu.bu.met.cs665.race.Dwarf;
import edu.bu.met.cs665.race.Elf;
import edu.bu.met.cs665.race.Human;
import edu.bu.met.cs665.race.Orc;
import edu.bu.met.cs665.race.Race;

/**
 * Utility class for providing type adapter factories for Gson
 * to enable polymorphic serialization and deserialization
 * of abstract types (Race, Job, GameCharacter).
 */
public class TypeAdapterUtil {

  /**
   * Returns a RuntimeTypeAdapterFactory for the Race hierarchy.
   * This allows Gson to correctly deserialize Race subclasses based on the "type" field.
   * 
   * @return A configured RuntimeTypeAdapterFactory for Race.
   */
  public static RuntimeTypeAdapterFactory<Race> raceAdapter() {
    return RuntimeTypeAdapterFactory.of(Race.class, "type")
        .registerSubtype(Human.class, "human")
        .registerSubtype(Elf.class, "elf")
        .registerSubtype(Orc.class, "orc")
        .registerSubtype(Dwarf.class, "dwarf")
        .registerSubtype(CustomRace.class, "custom");
  }

  /**
   * Returns a RuntimeTypeAdapterFactory for the Job hierarchy.
   * This allows Gson to correctly deserialize Job subclasses based on the "type" field.
   *
   * @return A configured RuntimeTypeAdapterFactory for Job.
   */
  public static RuntimeTypeAdapterFactory<Job> jobAdapter() {
    return RuntimeTypeAdapterFactory.of(Job.class, "type")
        .registerSubtype(Fighter.class, "fighter")
        .registerSubtype(Wizard.class, "wizard")
        .registerSubtype(Rogue.class, "rogue")
        .registerSubtype(Cleric.class, "cleric")
        .registerSubtype(CustomJob.class, "custom");
  }

  /**
   * Returns a RuntimeTypeAdapterFactory for the GameCharacter hierarchy.
   * This allows Gson to correctly deserialize GameCharacter subclasses based on the "type" field.
   *
   * @return A configured RuntimeTypeAdapterFactory for GameCharacter.
   */
  public static RuntimeTypeAdapterFactory<GameCharacter> characterAdapter() {
    return RuntimeTypeAdapterFactory.of(GameCharacter.class, "type")
        .registerSubtype(DefaultCharacter.class, "default");
  }
}
