package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.CustomerLife;
import com.sciera.cox.fp.domain.WorkOrder;
import com.sciera.cox.fp.spark.BaseSparkTest;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.junit.Assert;
import org.junit.Test;
import static org.apache.spark.sql.functions.not;
import static org.apache.spark.sql.functions.col;

import java.util.Arrays;
import java.util.List;

public class CustomerLifeLogic extends BaseSparkTest {

    @Test
    public void testLogic() {
        CustomerLife one = new CustomerLife();
        one.setCloseDate("20210806");

        CustomerLife two = new CustomerLife();
        two.setCloseDate("20190806");

        List<CustomerLife> customers = Arrays.asList(one,two);
        Dataset<CustomerLife> customerDS = toDataFrame(customers, CustomerLife.class);

        assert(customerDS.count() == 2);

        Dataset<CustomerLife> filtered = new CustomerLifeFilter("20200101","20210101").filterOut(customerDS);

        Assert.assertEquals(2,filtered.count());

    }
}
