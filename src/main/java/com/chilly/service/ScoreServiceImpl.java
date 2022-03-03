package com.chilly.service;

import com.chilly.dao.ScoreDao;
import com.chilly.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<Score> find(){
        return scoreDao.find();
    }

    @Override
    public void sum(String time) {
        scoreDao.sum(time);
    }
}
