package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */


public class Login {
    private String username;
    private String passward;

    Login(String Username , String passward){
        this.username = Username;
        this.passward  = passward;
    }

    Login()
    {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
}
