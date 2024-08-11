package com.yuanstack.scaffold.user.manager;

import com.yuanstack.scaffold.user.dao.project.ProjectRepository;
import com.yuanstack.scaffold.user.entity.project.ProjectEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Sylvan
 * @date 2024/08/11  21:46
 */
@Component
public class ProjectManager {
    @Resource
    private ProjectRepository projectRepository;

    public ProjectEntity findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
}
