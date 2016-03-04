package io.tenjin.kafka.connect.redshift.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Version {
  private static final Logger log = LoggerFactory.getLogger(Version.class);
  private static String version = "unknown";

  static {
    try {
      Properties props = new Properties();
      props.load(Version.class.getResourceAsStream("/kafka-connect-redshift-version.properties"));
      version = props.getProperty("version", version).trim();
    } catch (Exception e) {
      log.warn("Error while loading version:", e);
    }
  }

  public static String getVersion() {
    return version;
  }
}
