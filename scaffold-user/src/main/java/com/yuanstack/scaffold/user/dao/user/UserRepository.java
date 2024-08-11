package com.yuanstack.scaffold.user.dao.user;

import com.yuanstack.scaffold.user.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao
 *
 * @author Sylvan
 * @date 2024/08/11  20:33
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
