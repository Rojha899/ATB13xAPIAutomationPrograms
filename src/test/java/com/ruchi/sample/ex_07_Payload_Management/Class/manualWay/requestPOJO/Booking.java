package com.ruchi.sample.ex_07_Payload_Management.Class.manualWay.requestPOJO;

public class Booking {
    // Request is -
    //{       "firstname": "aanya",
    //        "lastname": "Avni",
    //        "totalprice": 2000,
    //        "depositpaid": true,
    //        "bookingdates": {
    //            "checkin": "2025-07-01",
    //            "checkout": "2025-08-01"
    //        },
    //        "additionalneeds": "Breakfast"
    //    }

    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
