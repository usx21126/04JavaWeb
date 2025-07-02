package com.xh.service.impl;

import com.xh.entity.Clazz;
import com.xh.entity.ClazzQueryParam;
import com.xh.entity.PageBean;
import com.xh.mapper.ClazzMapper;
import com.xh.mapper.StudentMapper;
import com.xh.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询
     * @param param
     * @return
     */
    @Override
    public PageBean getClazzs(ClazzQueryParam param) {
        PageBean pageBean = new PageBean();
        param.setOffset((param.getPage() - 1) * param.getPageSize());
        List<Clazz> clazzList = clazzMapper.getClazzs(param);
        LocalDate now = LocalDate.now();
        clazzList.forEach(clazz -> {
            if(now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            }else if(now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            }else {
                clazz.setStatus("已开班");
            }
        });
        pageBean.setTotal(clazzMapper.getCount());
        pageBean.setRows(clazzList);
        return pageBean;
    }

    /**
     * 根据id删除班级
     * @param id
     */
    @Transactional
    @Override
    public void deleteClazzs(Integer id) {
        studentMapper.deleteStudentsByClazzId(id);
        clazzMapper.deleteClazzs(id);
    }

    /**
     * 添加班级数据
     * @param clazz
     */
    @Override
    public void addClazzs(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazzs(clazz);
    }

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    /**
     * 修改课程数据
     * @param clazz
     */
    @Override
    public void updateClazz(Clazz clazz) {
        if(clazz != null) {
            clazzMapper.updateClazz(clazz);
        }

    }

    @Override
    public List<Clazz> getAllClazzs() {
        return clazzMapper.getAllClazzs();
    }
}
