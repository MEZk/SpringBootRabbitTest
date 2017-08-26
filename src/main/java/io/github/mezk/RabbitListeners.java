package io.github.mezk;

import java.net.UnknownHostException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.mezk.callbackprocessor.CallbackProcessor;
import io.github.mezk.callbackprocessor.CallbackProcessorFactory;

@Configuration
public class RabbitListeners {

    @Autowired
    @Qualifier("hostname")
    private String hostname;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private CallbackProcessorFactory processorsFactory;

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer1() throws UnknownHostException {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(hostname);
        container.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                CallbackProcessor processor = processorsFactory
                    .getProcessor(message.getMessageProperties().getType());
                processor.process(message.toString());
            }
        });
        return container;
    }

}
