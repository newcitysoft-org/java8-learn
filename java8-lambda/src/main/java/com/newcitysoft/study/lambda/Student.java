package com.newcitysoft.study.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 13:58
 */
@Data
@Builder
public class Student {
    private String stuId;
    private String name;
    private Gender gender;
    private int age;
    private String major;
    private String tel;
    private String bedroom;
}
