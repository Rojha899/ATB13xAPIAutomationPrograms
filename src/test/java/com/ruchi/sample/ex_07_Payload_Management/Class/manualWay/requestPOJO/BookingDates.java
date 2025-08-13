package com.ruchi.sample.ex_07_Payload_Management.Class.manualWay.requestPOJO;

public class BookingDates {
    // BookingDates has following - checkin & checkout
    //        "bookingdates": {
    //            "checkin": "2025-07-01",
    //            "checkout": "2025-08-01"
    //        },

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
