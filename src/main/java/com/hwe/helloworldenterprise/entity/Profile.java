package com.hwe.helloworldenterprise.entity;

public class Profile {
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name= "Profile")
public class Profile {
    @Id
    private long ID;
    private String name;
    private String email;
    private String picture;
    private String phone;
    private Enum_role role;
    private Date created_date;

    public Profile(long ID, String name, String email, String picture, String phone, Enum_role role, Date created_date) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.phone = phone;
        this.role = role;
        this.created_date = created_date;
    }
}

