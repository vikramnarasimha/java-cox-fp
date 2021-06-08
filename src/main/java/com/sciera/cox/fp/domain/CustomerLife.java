package com.sciera.cox.fp.domain;

public class CustomerLife {
    String customerAccountKey;
    String fpKey;

    public String getCustomerAccountKey() {
        return customerAccountKey;
    }

    public void setCustomerAccountKey(String customerAccountKey) {
        this.customerAccountKey = customerAccountKey;
    }

    public String getFpKey() {
        return fpKey;
    }

    public void setFpKey(String fpKey) {
        this.fpKey = fpKey;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getDisconnectFLDate() {
        return disconnectFLDate;
    }

    public void setDisconnectFLDate(String disconnectFLDate) {
        this.disconnectFLDate = disconnectFLDate;
    }

    String closeDate;
    String disconnectFLDate;

    //get rows that are not in the filter clause ...
}
