package com.yuanstack.scaffold.user;

import com.alibaba.fastjson2.JSON;
import com.yuanstack.scaffold.user.manager.ProjectManager;
import com.yuanstack.scaffold.user.manager.UserManager;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScaffoldUserApplicationTests {

    @Resource
    private ProjectManager projectManager;
    @Autowired
    private UserManager userManager;

    @Test
    void contextLoads() {
        System.out.println("项目数据：" + projectManager.findById(1L));
        String jsonString = JSON.toJSONString(userManager.findById(1L));
        System.out.println("用户数据：" + jsonString);
    }
}
