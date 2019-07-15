package com.lcoa.ems;

public class additional {

    String name,number,add,dateofj,worke;


    public additional(String name, String number, String add, String dateofj, String worke) {
        this.name = name;
        this.number = number;
        this.add = add;
        this.dateofj = dateofj;
        this.worke = worke;
    }

    public additional() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDateofj() {
        return dateofj;
    }

    public void setDateofj(String dateofj) {
        this.dateofj = dateofj;
    }

    public String getWorke() {
        return worke;
    }

    public void setWorke(String worke) {
        this.worke = worke;
    }
}
