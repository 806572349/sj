package com.nemo.sj.miaosha.mq;

import com.nemo.sj.miaosha.common.cache.RedisService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by Nemo
 * 2018/8/15  14:16
 */
@Service
public class MQSender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public  void send(Object message){
        String s = RedisService.beanToString(message);

        amqpTemplate.convertAndSend(MQConfig.Q,s);
    }


    public  void sendTopic(Object message){
        String s = RedisService.beanToString(message);

        amqpTemplate.convertAndSend(MQConfig.Topicex,MQConfig.Route_KEY1,s+""+1);
        amqpTemplate.convertAndSend(MQConfig.Topicex,MQConfig.Route_KEY2,s+""+1);
    }

}
