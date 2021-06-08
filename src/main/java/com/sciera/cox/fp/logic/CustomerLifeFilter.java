package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.CustomerLife;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;

public class CustomerLifeFilter {

    public Dataset<CustomerLife> filterOut(Dataset<CustomerLife> customers){
        return customers.filter(
                (FilterFunction<CustomerLife>) customer -> {
                    if(customer.getCustomerAccountKey() != null){
                        return false;
                    }
                    return customer.getCloseDate() != null;
                }
        );
    }
}
