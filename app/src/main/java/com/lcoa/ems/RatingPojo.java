package com.lcoa.ems;

public class RatingPojo {
    private String EmailAdd;
    private String Name;
    private String rating;

    public RatingPojo(String Email, String Nameofuser, String Rating) {
        this.EmailAdd=Email;
        this.Name=Nameofuser;
        this.rating=Rating;
    }
    public RatingPojo()
    {

    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }





}
