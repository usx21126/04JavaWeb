package com.xh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCountData {
    private List<String> clazzList;     //班级列表
    private List<Integer> dataList;     //每一个班级的人数列表

}
