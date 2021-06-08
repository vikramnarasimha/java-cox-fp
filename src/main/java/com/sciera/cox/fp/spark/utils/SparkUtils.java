package com.sciera.cox.fp.spark.utils;

import org.apache.spark.sql.SparkSession;

public class SparkUtils {

    public static SparkSession create(String applicationName,
                               String master) {
        return SparkSession.builder()
                .appName(applicationName)
                .master(master)
                .getOrCreate();
    }
}
