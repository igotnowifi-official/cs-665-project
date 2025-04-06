/**
 * Name: Natasya Liew U15913137
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/05/2025
 * File Name: JobFileIO.java
 * Description: Utility class for saving and loading individual custom Job objects
 *              to and from the assets/jobs/ folder using Gson.
 */

package edu.bu.met.cs665.job.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.bu.met.cs665.job.Job;
import edu.bu.met.cs665.util.TypeAdapterUtil;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Provides static methods for saving and loading custom jobs to/from JSON files.
 */
public class JobFileIO {
  private static final String JOB_DIR = "assets/jobs/";
 
  private static final Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(TypeAdapterUtil.jobAdapter())
      .setPrettyPrinting()
      .create();
 
  /**
   * Saves a single custom job to a JSON file named after the job name.
   * @param job The custom job object to save.
   */
  public static void save(Job job) {
    File file = new File(JOB_DIR + job.getJobName().toLowerCase() + ".json");
    file.getParentFile().mkdirs();
    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(job, writer);
    } catch (IOException e) {
      System.err.println("[ERROR]: Failed to save job " + job.getJobName() + ": " + e.getMessage());
    }
  }
 
  /**
   * Loads all job JSON files from the jobs folder and returns a map of job name to Job object.
   * @return A map of job name (lowercased) to Job object.
   */
  public static Map<String, Job> loadAll() {
    Map<String, Job> jobs = new HashMap<>();
    File folder = new File(JOB_DIR);
    if (!folder.exists()) {
      folder.mkdirs();
    }

    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
    if (files == null) {
      return jobs;
    }
 
    for (File file : files) {
      try (FileReader reader = new FileReader(file)) {
        Job job = gson.fromJson(reader, Job.class);
        if (job != null) {
          jobs.put(job.getJobName().toLowerCase(), job);
        }
      } catch (IOException e) {
        System.err.println("[ERROR]: Failed to load job from file " + file.getName());
      }
    }
 
    return jobs;
  }

  /**
   * Loads a single job from a JSON file given its name.
   * @param jobName The name of the job (filename without .json).
   * @return The Job instance loaded from file.
   * @throws RuntimeException if the file cannot be read.
   */
  public static Job load(String jobName) {
    try {
      String filePath = "assets/jobs/" + jobName + ".json";
      return gson.fromJson(new FileReader(filePath), Job.class);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load job: " + jobName, e);
    }
  }
}
 