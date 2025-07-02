package com.xh.mapper;

import com.xh.entity.Clazz;
import com.xh.entity.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询
     * @param param
     * @return
     */
    List<Clazz> getClazzs(ClazzQueryParam param);

    /**
     * 根据id删除班级
     * @param id
     */
    void deleteClazzs(Integer id);

    /**
     * 添加班级数据
     * @param clazz
     */
    void addClazzs(Clazz clazz);

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    Clazz getClazzById(Integer id);

    /**
     * 修改课程数据
     * @param clazz
     */
    void updateClazz(Clazz clazz);

    List<Clazz> getAllClazzs();

    Integer getCount();
}
