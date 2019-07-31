package com.lcoa.ems;

public class Image_POJO {
    private String userid;
    private String Emailid;
    private String LINK;

    public Image_POJO()
    {

    }
    public Image_POJO(String USERID, String EMAILID, String link)
    {
        this.userid=USERID;
        this.Emailid=EMAILID;
        this.LINK=link;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public String getLINK() {
        return LINK;
    }

    public void setLINK(String LINK) {
        this.LINK = LINK;
    }
}
