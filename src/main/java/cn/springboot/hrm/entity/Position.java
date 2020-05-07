package cn.springboot.hrm.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Position)实体类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position implements Serializable {
    private static final long serialVersionUID = -71657326556534526L;
    /**
    * 职位id
    */
    private Integer id;
    /**
    * 所属部门
    */
    private String departmentobj;
    /**
    * 职位名称
    */
    private String positionname;
    /**
    * 基本工资
    */
    private Object basesalary;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * 对象封装
     */
    private Department department;


}