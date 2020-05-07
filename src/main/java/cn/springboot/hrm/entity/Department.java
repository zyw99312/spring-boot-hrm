package cn.springboot.hrm.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department implements Serializable {
    private static final long serialVersionUID = 979531812661997158L;
    
    private Integer id;
    /**
    * departmentNo
    */
    private String departmentno;
    /**
    * 部门名称
    */
    private String departmentname;

}