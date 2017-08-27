package io.github.mezk.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public void callback(
        @RequestParam("rk") String routingKey,
        @RequestParam("callbackType") String callbackType
    ) throws UnknownHostException {
        rabbitTemplate.convertAndSend(routingKey, "Callback", message -> {
            message.getMessageProperties().setType("CallbackProcessor1");
            return message;
        });
    }

}
