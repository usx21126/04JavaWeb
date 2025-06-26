package com.xh.mapper;

import com.xh.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //程序启动时，自动生成接口的代理对象，交由IOC容器管理
public interface UserMapper {

    //查询所有用户数据
    //@Select("select * from user")
    public List<User> findAll();


}
