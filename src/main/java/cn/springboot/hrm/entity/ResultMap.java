package cn.springboot.hrm.entity;

import lombok.*;

/**
 * @author zyw
 * @version 1.0
 * @date 2020/4/25 16:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultMap<T> {
    private int code;
    private String msg;
    private T data;
}
