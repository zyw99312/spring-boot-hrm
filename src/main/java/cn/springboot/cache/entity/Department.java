package cn.springboot.cache.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author zyw
 * @since 2020-03-25 20:37:05
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -40301651485771012L;
    
    private Integer id;
    
    private String departmentname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }
}