package com.sciera.cox.fp.spark;

import junit.framework.TestSuite;
import org.apache.spark.sql.SparkSession;

public class SparkUtilsForTest extends TestSuite {

    public static SparkSession getSpark(String applicationName) {
        return SparkSession.builder()
                .appName(applicationName)
                .master("local")
                .getOrCreate();
    }
}
