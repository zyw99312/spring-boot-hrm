package cn.springboot.hrm.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author zyw
 * @since 2020-03-26 19:18:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin implements Serializable {
    private static final long serialVersionUID = -16013676267686497L;
    
    private Integer id;
    
    private String username;
    
    private String password;

}