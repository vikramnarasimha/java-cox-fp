package com.sciera.cox.fp.logic;

import com.sciera.cox.fp.domain.CustomerLife;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerLifeFilter implements java.io.Serializable{

    LocalDate startDate;
    LocalDate endDate;

    public CustomerLifeFilter(String startDate, String endDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.startDate = LocalDate.from(dtf.parse(startDate));
        this.endDate = LocalDate.from(dtf.parse(endDate));
    }

    public boolean isCloseDateBetweenStartAndEndDate(CustomerLife customer) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate s = LocalDate.from(dtf.parse(customer.getCloseDate()));
        return s.isAfter(startDate) && s.isBefore(endDate);
    }

    public Dataset<CustomerLife> filterOut(Dataset<CustomerLife> customers){
        return customers.filter(
                (FilterFunction<CustomerLife>) customer -> {
                    return isCloseDateBetweenStartAndEndDate(customer);
                }
        );
    }
}