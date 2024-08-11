package com.yuanstack.scaffold.user.dao.project;

import com.yuanstack.scaffold.user.entity.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao
 *
 * @author Sylvan
 * @date 2024/08/11  20:33
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
