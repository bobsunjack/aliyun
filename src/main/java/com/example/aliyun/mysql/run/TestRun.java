package com.example.aliyun.mysql.run;

import com.alibaba.fastjson.JSONObject;
import com.example.aliyun.mysql.dao.TestDao;
import com.example.aliyun.mysql.entity.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Order(100)
public class TestRun implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(TestRun.class);
    @Autowired
    TestDao testDao;
    @Override
    public void run(String... args) throws Exception {
       List<Hotel> hotelList= testDao.findAll();
        for (Hotel hotel : hotelList) {
            System.out.printf(hotel.getId());
            logger.error(JSONObject.toJSONString(hotel));
        }
    }
}
