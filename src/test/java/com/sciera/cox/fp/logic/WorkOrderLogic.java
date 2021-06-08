package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.WorkOrder;
import com.sciera.cox.fp.spark.BaseSparkTest;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class WorkOrderLogic extends BaseSparkTest {

    @Test
    public void testLogic() {
        WorkOrder one = new WorkOrder();
        one.setId("1");
        one.setProvider("XXX");
        one.setStatus("Inactive");

        WorkOrder two = new WorkOrder();
        two.setId("2");
        two.setProvider("YYY");
        two.setStatus("Active");

        List<WorkOrder> workOrders = Arrays.asList(one,two);
        Dataset<WorkOrder> workOrdersDS = toDataFrame(workOrders, WorkOrder.class);

        assert(workOrdersDS.count() == 2);

        Dataset<String> workOrderIds = workOrdersDS.map(
                (MapFunction<WorkOrder,String>) workOrder -> workOrder.getId(), Encoders.STRING()
        );

        Assert.assertEquals(workOrderIds.count() ,2);

    }
}
