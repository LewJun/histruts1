package com.microandroid.modules.login.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
    private String username;

    private String password;

    public LoginForm() {
        super();
    }

    public LoginForm(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
