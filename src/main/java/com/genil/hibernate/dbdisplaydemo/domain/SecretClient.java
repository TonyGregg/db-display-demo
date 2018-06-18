package com.genil.hibernate.dbdisplaydemo.domain;

/**
 * Created by genil on 6/17/18 at 12 13
 **/

import javax.persistence.*;
import java.util.List;

/**
 * For authentication
 *
 * 1.secretclient
 * 2.roles
 * 3.UserRoles
 *
 * Go and enjoy coding from patio !
 */
@Entity
public class SecretClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String email;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="USER_ID",
                    referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID",
                    referencedColumnName="ID")})
    private List<Roles> roles;


}
