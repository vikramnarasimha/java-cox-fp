package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.WorkOrder;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;

public class WorkOrderFilter {

    public Dataset<WorkOrder> filterByIds(Dataset<WorkOrder> workOrders){
       return workOrders.filter(
                (FilterFunction<WorkOrder>) workOrder -> workOrder.getId().equals("xx")
        );
    }
}
