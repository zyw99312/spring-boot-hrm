package cn.springboot.hrm.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Employees)实体类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employees implements Serializable {
    private static final long serialVersionUID = -24707557005187793L;
    
    private Integer id;
    /**
    * 员工编号
    */
    private String employeeno;
    /**
    * 职位
    */
    private String positionobj;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别
    */
    private String sex;
    /**
    * 出生日期
    */
    private String birthday;
    /**
    * 学历
    */
    private String schoolrecord;
    /**
    * 员工介绍
    */
    private String employeedesc;

    /**
     * 职位对象
     */
    private Position position;


}