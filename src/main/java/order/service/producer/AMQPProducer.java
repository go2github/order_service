package order.service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import order.service.config.RabbitMQProperties;
import order.service.pojo.Order;
import order.service.pojo.RequestMessage;

@Component
public class AMQPProducer {
	
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMQProperties rabbitMQProperties;

    public void sendMessage(String msg){
        System.out.println("Send msg = " + msg.toString());
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), rabbitMQProperties.getRoutingKey(), msg);
    }
    
    public void sendMessage(RequestMessage req){
        System.out.println("Send msg = " + req.toString());
        rabbitTemplate.convertAndSend(rabbitMQProperties.getExchangeName(), rabbitMQProperties.getRoutingKey(), req);
    }

}
