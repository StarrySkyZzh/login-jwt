package com.chilly.dao;

import com.chilly.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreDao {
    List<Score> find();

    void sum(String time);
}
