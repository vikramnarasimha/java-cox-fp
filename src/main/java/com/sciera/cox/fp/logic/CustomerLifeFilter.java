package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.CustomerLife;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.joda.time.format.DateTimeFormat;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class CustomerLifeFilter {

    Instant startDate;
    Instant endDate;
    DateTimeFormatter dtf;
    public CustomerLifeFilter(String startDate, String endDate){
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = Instant.from(dtf.parse(startDate));
        this.endDate = Instant.from(dtf.parse(endDate));
    }

    public boolean isCloseDateBetweenStartAndEndDate(CustomerLife customer) {
        Instant s = Instant.from(dtf.parse(customer.getCloseDate()));
        return s.isAfter(startDate) && s.isBefore(endDate);
    }

    public Dataset<CustomerLife> filterOut(Dataset<CustomerLife> customers){
        return customers.filter(
                (FilterFunction<CustomerLife>) customer -> {
                    return !isCloseDateBetweenStartAndEndDate(customer);
                }
        );
    }
}
