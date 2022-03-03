package com.chilly.service;

import com.chilly.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> find();

    void sum(String time);
}
