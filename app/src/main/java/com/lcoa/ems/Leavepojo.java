package com.lcoa.ems;

public class Leavepojo {
    private  String date1;
    private String date2;
    private String Emailadd;
    private  String Name;
    private  String reason;
    private String Status;

    public Leavepojo(String Date1, String Date2,String EMAILadd,String NAME, String Reason, String status) {
        this.date1=Date1;
        this.date2=Date2;
        this.Emailadd=EMAILadd;
        this.Name=NAME;
        this.reason=Reason;
        this.Status=status;


    }

    public String getName() {
        return Name;
    }

    public String getReason() {
        return reason;
    }



    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailadd() {
        return Emailadd;
    }

    public void setEmailadd(String emailadd) {
        Emailadd = emailadd;
    }

    public Leavepojo()
    {

    }

    public String getDate1() {
        return date1;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }


}
