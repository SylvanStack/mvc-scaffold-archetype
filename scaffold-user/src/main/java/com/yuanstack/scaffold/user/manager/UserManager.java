package com.yuanstack.scaffold.user.manager;

import com.yuanstack.scaffold.user.dao.user.UserRepository;
import com.yuanstack.scaffold.user.entity.user.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Sylvan
 * @date 2024/08/11  21:47
 */
@Component
public class UserManager {

    @Resource
    private UserRepository userRepository;

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
