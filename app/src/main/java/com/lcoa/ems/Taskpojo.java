package com.lcoa.ems;

public class Taskpojo {
    private String Userid;
    private String Username;
    private String password;
    private String email;
    private String designation;
    private additional addi;






    public  Taskpojo()
    {

    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Taskpojo(String userid, String username, String password, String email, String designation, additional addd )
    { this.addi=addd;
       this.Userid=userid;
       this.Username=username;
       this.password=password;
       this.email=email;
       this.designation=designation;
    }


    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public additional getAddi() {
        return addi;
    }

    public void setAddi(additional addi) {
        this.addi = addi;
    }



}
