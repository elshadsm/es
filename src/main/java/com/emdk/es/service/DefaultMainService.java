package com.emdk.es.service;

import com.emdk.es.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by HP on 25.08.2015.
 */

@Service
public class DefaultMainService implements MainService{


    @Autowired
    MainDao mainDao;


    @Override
    public boolean updateExample(int id, String value) {
        return mainDao.updateExample(id,value);
    }

    @Override
    public String selectExample(int id) {
        return mainDao.selectExample(id);
    }

    @Override
    public int insertExample(int id, Date date) {
        return mainDao.insertExample(id,date);
    }

    @Override
    public boolean deleteExample(int id) {
        return mainDao.deleteExample(id);
    }

    @Override
    public List<Integer> selectListExample() {
        return mainDao.selectListExample();
    }
}
