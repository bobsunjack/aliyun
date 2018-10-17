package com.example.aliyun.activemq.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
/*@Component*/
public class Consumer {
    @JmsListener(destination = "SNAP_IMAGE_INFO_TOPIC")
    public void receiveQueue(String text) {
        log.info(">> {}", text);
    }
}
