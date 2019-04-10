package com.framework.v1.business.mq.consumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class FirstConsumerDemo {

    @JmsListener(destination = "firstJmsQueneDestination",containerFactory="firstJmsQueneListenerFactory")
    public void firstConsumeQuene(final String msg) throws JMSException, Exception{
        System.out.println("----firstQueneConsumer:"+msg);
    }


    @JmsListener(destination = "firstJmsTopicDestination",containerFactory="firstJmsTopicListenerFactory")
    public void firstConsumeTopic(final String msg) throws JMSException, Exception{
        System.out.println("----firstTopicConsumer:"+msg);
    }


    @JmsListener(destination = "secondJmsQueneDestination",containerFactory="secondJmsQueneListenerFactory")
    public void secondConsumeQuene(final String msg) throws JMSException, Exception{
        System.out.println("----secondQueneConsumer:"+msg);
    }


    @JmsListener(destination = "secondJmsTopicDestination",containerFactory="secondJmsTopicListenerFactory")
    public void secondConsumeTopic(final String msg) throws JMSException, Exception{
        System.out.println("----secondTopicConsumer:"+msg);
    }

}
