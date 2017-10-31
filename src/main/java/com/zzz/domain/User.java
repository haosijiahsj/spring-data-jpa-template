package com.zzz.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hushengjun on 2017/9/14.
 */
@Data
@Entity
@Table(name = "zzz_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_info", insertable = false, updatable = false)
    private UserInfo userInfo;
}
