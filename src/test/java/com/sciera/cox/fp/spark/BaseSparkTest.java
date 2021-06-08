package com.sciera.cox.fp.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;

import java.util.List;


public class BaseSparkTest extends SparkUtilsForTest {
    public <T> Dataset<T> toDataFrame(List<T> items, Class<T> c) {
        return getSpark("test")
                .createDataset(items, Encoders.bean(c));
    }
}
