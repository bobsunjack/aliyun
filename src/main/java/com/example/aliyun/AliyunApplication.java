package com.example.aliyun;


import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
@MapperScan("com.example.aliyun.mysql.dao")
public class AliyunApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliyunApplication.class, args);
    }


    @Bean
    public Queue queue() {
        return new ActiveMQQueue("SNAP_IMAGE_INFO_TOPIC");
    }
}
