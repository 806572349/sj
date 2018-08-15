package com.nemo.sj.miaosha.mq;

import com.nemo.sj.miaosha.common.cache.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * create by Nemo
 * 2018/8/15  14:16
 */
@Slf4j
@Service
public class MQReceiver {

    @RabbitListener(queues = MQConfig.Q)
    public void receive(String msg){
        log.info("我收到了数据");
    }

    @RabbitListener(queues = MQConfig.Q1)
    public void receive2(String msg){
        log.info("topicQ1我收到了数据"+msg);
    }

    @RabbitListener(queues = MQConfig.Q2)
    public void receive3(String msg){
        log.info("topicQ2我收到了数据"+msg);
    }
}
