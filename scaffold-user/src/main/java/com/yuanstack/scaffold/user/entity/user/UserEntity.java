package com.yuanstack.scaffold.user.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Sylvan
 * @date 2024/08/11  20:33
 */
@Data
@ToString
@Entity
@Table(name = "user_info")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * md5 加密密码
     */
    @Column(name = "md5_password")
    private String md5Password;
}
