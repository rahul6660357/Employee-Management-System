package com.lcoa.ems;

import java.text.DateFormat;
import java.util.Date;

public class Attendance_fire_pojo {
    private String Userid;
    private String Emailadd;
    private String Location;
    private String Datetime;
    private String status;

    Attendance_fire_pojo(String userid, String emailid, String location, String date, String status)
    {
        this.Userid=userid;
        this.Emailadd=emailid;
        this.Location=location;
        this.Datetime=date;
        this.status=status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return Userid;
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }


    public String getEmailadd() {
        return Emailadd;
    }

    public void setEmailadd(String emailadd) {
        Emailadd = emailadd;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    Attendance_fire_pojo(String userId, String name, String fulladdress, Date currentTime)
    {

    }
}
