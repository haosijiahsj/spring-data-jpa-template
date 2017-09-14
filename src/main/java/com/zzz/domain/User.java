package com.zzz.domain;

import javax.persistence.*;

/**
 * Created by hushengjun on 2017/9/14.
 */
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

    @Column(name = "user_info")
    private Long user_info_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_info", insertable = false, updatable = false)
    private UserInfo userInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Long getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(Long user_info_id) {
        this.user_info_id = user_info_id;
    }
}
