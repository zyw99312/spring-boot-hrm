package cn.springboot.cache.entity;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author zyw
 * @since 2020-03-25 20:37:06
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 831753617923881979L;
    
    private Integer id;
    
    private String lastname;
    
    private String email;
    
    private Integer gender;
    
    private Integer dId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dId=" + dId +
                '}';
    }
}