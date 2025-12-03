package org.xd.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private Integer page = 1;
    //分页查询的页码，如果未指定，默认为1
    private Integer pageSize = 10;
    //分页查询的每页记录数，如果未指定，默认为10
    private String name;
    //班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //范围匹配的开始时间(结课时间)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //范围匹配的结束时间(结课时间)
}
