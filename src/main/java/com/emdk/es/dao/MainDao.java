package com.emdk.es.dao;

import java.util.Date;
import java.util.List;

/**
 * Created by HP on 25.08.2015.
 */
public interface MainDao {

    public boolean updateExample(int id, String value);
    public String selectExample(int id);
    public int insertExample(int id, Date date);
    public boolean deleteExample(int id);
    public List<Integer> selectListExample();



}
