package com.zzz.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hushengjun on 2017/9/14.
 */
@Data
@Entity
@Table(name = "zzz_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "birthday")
    private Date birthday;
}
