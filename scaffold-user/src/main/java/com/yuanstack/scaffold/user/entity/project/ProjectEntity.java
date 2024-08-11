package com.yuanstack.scaffold.user.entity.project;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Sylvan
 * @date 2024/08/11  20:33
 */
@Data
@Entity
@NoArgsConstructor
@ToString
@Table(name = "project_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目类型
     */
    private Integer type;

    /**
     * 项目描述
     */
    private String description;
}
