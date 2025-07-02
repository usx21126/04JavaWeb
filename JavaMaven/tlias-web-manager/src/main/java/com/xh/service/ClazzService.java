package com.xh.service;

import com.xh.entity.Clazz;
import com.xh.entity.ClazzQueryParam;
import com.xh.entity.PageBean;

import java.util.List;

public interface ClazzService {
    PageBean getClazzs(ClazzQueryParam param);

    void deleteClazzs(Integer id);

    void addClazzs(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> getAllClazzs();
}
