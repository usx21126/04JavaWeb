package com.xh.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class ClazzQueryParam {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate end;
    private Integer page = 1;
    private Integer pageSize = 10;

    // offset: 起始查询编号
    private Integer offset;

}
