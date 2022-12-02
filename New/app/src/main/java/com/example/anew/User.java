package com.example.anew;

public class User {
    String fName,email,userId;
    Integer mobile;

    public User(){
        //no argument user
    }

    public User(String fName, String email, Integer mobile, String userId) {
        this.fName = fName;
        this.email = email;
        this.mobile = mobile;

        this.userId = userId;
    }



    public String getfName() {
        return fName;
    }

    public String getlName() {
        return email;
    }

    public String getuserId() {
        return userId;
    }

    public int getMobile(){ return mobile; }



    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setuserID(String userId) {
        this.userId = userId;
    }

    public void setlName(String email) {
        this.email = email;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }


}
