package com.chilly.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Teacher {
    private String iid;
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String lessons;
    private String college;
}
