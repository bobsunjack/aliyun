package com.example.aliyun.mysql.dao;

import com.example.aliyun.mysql.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDao {
    @Select("Select * from HotelOrderRuler")
    List<Hotel> findAll();
}
