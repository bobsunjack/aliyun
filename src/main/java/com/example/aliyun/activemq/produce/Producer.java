package com.example.aliyun.activemq.produce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Slf4j
/*@Component
@EnableScheduling*/
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 3000)
    // 每3s执行1次
    public void send() {
        log.info(">> send !!!");
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }

}
