package active.mq.producer.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    public String brokerUrl;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(ConfigConstants.QUEUE_NAME);
    }

    @Bean
    public Queue myQueue() {
        return new ActiveMQQueue(ConfigConstants.MY_QUEUE_NAME);
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setTrustAllPackages(true);
        factory.setBrokerURL(brokerUrl);
        return factory;
    }
    @Bean
    public JmsTemplate jmsTemp() {
        return new JmsTemplate(activeMQConnectionFactory());
    }
}
