package com.xh;

import com.xh.entity.User;
import com.xh.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //加载spring环境(IOC容器)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> list =  userMapper.findAll();
        for(User user : list){
            System.out.println(user);
        }
    }
}
