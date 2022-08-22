package com.hwe.helloworldenterprise.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable {
    @Id
    private long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String document;
    private String phone;
    private String address;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

}
