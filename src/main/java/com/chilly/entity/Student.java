package com.chilly.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Student {
    private String iid;
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String lessons;
    private String college;
}
