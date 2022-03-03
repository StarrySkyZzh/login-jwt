package com.chilly.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Course {

    private String topic;
    private String answer;
    private String id;
    private String score;
    private String ans;
}
