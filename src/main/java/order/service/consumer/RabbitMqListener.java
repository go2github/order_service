package order.service.consumer;

import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import order.service.pojo.RequestMessage;
import order.service.pojo.Foo;
import order.service.pojo.Order;
import order.service.pojo.Product;

@Component
public class RabbitMqListener {

	// @RabbitListener(queues="${rabbitmq.queueName}")
	public void listen(byte[] message) {
		String msg = new String(message);
		RequestMessage req = new Gson().fromJson(msg, RequestMessage.class);

		System.out.println("Received a new notification... "+req.getType());

		switch (req.getType()) {

		case "order":
			System.out.println("order--------------");
			System.out.println(req.getOrder().getOrderId());
			break;
		case "product":
			System.out.println("product--------------");
			System.out.println(req.getProduct().getName());
			break;

		}

		//System.out.println(req.toString());
	}
}
