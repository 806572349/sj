package com.nemo.sj.miaosha.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by Nemo
 * 2018/8/15  14:16
 */
@Configuration
public class MQConfig {
    public static final String Q="queue";
    public static final String Q1="topic.queue1";
    public static final String Q2="topic.queue2";
    public static final String Topicex="Topicexchange";

    public static final String Route_KEY1="topic.K1";
    public static final String Route_KEY2="topic.#";
    /**
     * Direct
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(Q,true);
    }
    //region  topic




    @Bean
    public Queue queue1(){
        return new Queue(Q1,true);
    }
    @Bean
    public Queue queue2(){
        return new Queue(Q2,true);
    }
    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange(Topicex);
    }

    @Bean
    public Binding topicBinding(){
        return BindingBuilder.bind(queue1()).to(topicExchange()).with(Route_KEY1);
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("topic.#");
    }
    //endregion

    //region  Fanout 模式




        //endregion



}
