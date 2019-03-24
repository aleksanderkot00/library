package com.crud.library.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "CREATION_DATE")
    private Date accountCreationDate;

    public User(String name, String lastName, Date accountCreationDate) {
        this.name = name;
        this.lastName = lastName;
        this.accountCreationDate = accountCreationDate;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(accountCreationDate, user.accountCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, accountCreationDate);
    }
}
