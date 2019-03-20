package com.crud.library.domain.Dto;

import java.sql.Date;

public class UserDto {
    private String name;
    private String lastName;
    private Date accountCreationDate;

    public UserDto() {
    }

    public UserDto(String name, String lastName, Date accountCreationDate) {
        this.name = name;
        this.lastName = lastName;
        this.accountCreationDate = accountCreationDate;
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
}
