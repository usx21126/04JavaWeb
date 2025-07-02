package com.xh.entity;

import lombok.Data;

@Data
public class StudentQueryParam {
    private String name;            //学员姓名
    private Integer degree;         //学历 1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士
    private Integer clazzId;        //课程id
    private Integer page = 1;       //页面编号
    private Integer pageSize = 10;   //页面大小

    private Integer offset = 0; //查询起始编号

}
