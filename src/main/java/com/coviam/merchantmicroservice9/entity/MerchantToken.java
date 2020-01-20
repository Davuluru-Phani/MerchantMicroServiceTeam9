package com.coviam.merchantmicroservice9.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "merchantlogin")
public class MerchantToken {

    @Id
    @Column(name = "id")
    private String uuid;
    private String merchEmail;

}
