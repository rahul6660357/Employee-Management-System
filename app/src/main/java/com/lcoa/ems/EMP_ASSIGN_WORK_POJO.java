package com.lcoa.ems;

public class EMP_ASSIGN_WORK_POJO {
    private  String EMAILID;
    private  String NAME;
    private String WoRKASS;
    private String status;
    public EMP_ASSIGN_WORK_POJO(String email, String name, String WORK, String status) {
        this.EMAILID=email;
        this.NAME=name;
        this.WoRKASS=WORK;
        this.status=status;
    }

    public String getEMAILID() {
        return EMAILID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEMAILID(String EMAILID) {
        this.EMAILID = EMAILID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getWoRKASS() {
        return WoRKASS;
    }

    public void setWoRKASS(String woRKASS) {
        WoRKASS = woRKASS;
    }
}

