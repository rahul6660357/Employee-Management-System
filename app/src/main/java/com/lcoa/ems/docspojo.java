package com.lcoa.ems;

public class docspojo {
    String Ugdetails, DegreeName,  UniversityName,
            Passingyear,
    DegreeMarks;
    public docspojo( String ugdetails, String degreeName, String universityName, String passingyear, String degreeMarks)
    {
        this.Ugdetails=ugdetails;
        this.DegreeName=degreeName;
        this.UniversityName=universityName;
        this.Passingyear=passingyear;
        this.DegreeMarks=degreeMarks;
    }
public docspojo()
{

}

    public String getDegreeName() {
        return DegreeName;
    }

    public void setDegreeName(String degreeName) {
        DegreeName = degreeName;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public String getPassingyear() {
        return Passingyear;
    }

    public void setPassingyear(String passingyear) {
        Passingyear = passingyear;
    }

    public String getDegreeMarks() {
        return DegreeMarks;
    }

    public String getUgdetails() {
        return Ugdetails;
    }

    public void setUgdetails(String ugdetails) {
        Ugdetails = ugdetails;
    }

    public void setDegreeMarks(String degreeMarks) {
        DegreeMarks = degreeMarks;
    }




}
