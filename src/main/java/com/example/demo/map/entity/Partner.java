package com.example.demo.map.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "partner")
@Getter @Setter
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty(value = "is_active")
    @Column(name = "is_active")
    private boolean active;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

    @JsonProperty(value = "pay_cug")
    @Column(name = "pay_cug")
    private boolean payCug;

    @JsonProperty(value = "created_at")
    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @JsonProperty(value = "code")
    @Column(name = "code")
    private String code;

    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "company_code")
    @Column(name = "company_code")
    private String companyCode;

    @JsonProperty(value = "mcrb_code")
    @Column(name = "mcrb_code")
    private String mcrbCode;

    //@JsonProperty(value = "cug")
    //@ManyToOne
    //@JoinColumn(name = "cug", referencedColumnName = "id")
    //private ClosedUserGroup cug;

    @JsonProperty(value = "sage_code")
    @Column(name = "sage_code")
    private String sageCode;

    @JsonProperty(value = "cbk_api_code")
    @Column(name = "cbk_api_code")
    private String cbkApiCode;

    @JsonProperty(value = "sage_customer_id")
    @Column(name = "sage_customer_id")
    private Integer sageCustomerId;


    public Partner() {
    }
}