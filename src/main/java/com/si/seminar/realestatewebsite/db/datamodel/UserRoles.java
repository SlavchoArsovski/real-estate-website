package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;

/**
 * User Roles.
 */
@Entity
@Table(name = "PORTAL_USER_ROLES")
@Access(AccessType.FIELD)
public class UserRoles {

    @Id
    @Column(name = "USER_ROLE_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "ROLE")
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
