package com.chilly.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Score {
    private String name;
    private String course;
    private String time;
    private String number;
    private String subject;
}
