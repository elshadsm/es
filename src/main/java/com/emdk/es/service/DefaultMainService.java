package com.emdk.es.service;

import com.emdk.es.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HP on 25.08.2015.
 */

@Service
public class DefaultMainService implements MainService{


    @Autowired
    MainDao mainDao;



}
