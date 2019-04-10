package com.framework.v1.framework.config.mq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
public class MqConfig {


    @Autowired
    private FirstMqBean firstMqBean;

    @Autowired
    private SecondMqBean secondMqBean;



    @Bean(name = "firstConnectionFactory")
    @Primary
    public ActiveMQConnectionFactory firstConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(firstMqBean.getBrokerUrl());
        factory.setUserName(firstMqBean.getUser());
        factory.setPassword(firstMqBean.getPassword());
        return factory;
    }

    @Bean(name = "secondConnectionFactory")
    public ActiveMQConnectionFactory secondConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(secondMqBean.getBrokerUrl());
        factory.setUserName(secondMqBean.getUser());
        factory.setPassword(secondMqBean.getPassword());
        return factory;
    }


    @Bean(name = "firstActivemqTemplate")
    @Primary
    public JmsMessagingTemplate innerActivemqTemplate(
            @Qualifier("firstConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        JmsMessagingTemplate template = new JmsMessagingTemplate(connectionFactory);
        return template;
    }

    @Bean(name = "secondActivemqTemplate")
    public JmsMessagingTemplate secondActivemqTemplate(
            @Qualifier("secondConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        JmsMessagingTemplate template = new JmsMessagingTemplate(connectionFactory);
        return template;
    }

    @Bean(name = "firstJmsQueneListenerFactory")
    public JmsListenerContainerFactory firstJmsQueneListenerFactory(
            @Qualifier("firstConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean(name = "firstJmsTopicListenerFactory")
    public JmsListenerContainerFactory firstJmsTopicListenerFactory(
            @Qualifier("firstConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean(name = "secondJmsQueneListenerFactory")
    public JmsListenerContainerFactory secondJmsQueneListenerFactory(
            @Qualifier("secondConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean(name = "secondJmsTopicListenerFactory")
    public JmsListenerContainerFactory secondJmsTopicListenerFactory(
            @Qualifier("secondConnectionFactory") ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }


}
