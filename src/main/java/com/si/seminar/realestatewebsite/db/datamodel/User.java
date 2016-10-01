package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;

/**
 * User.
 */
@Entity
@Table(name = "PORTAL_USER")
@Access(AccessType.FIELD)
public class User {

    @Id
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
