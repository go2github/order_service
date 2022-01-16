package order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import order.service.pojo.Order;
import order.service.pojo.Product;
import order.service.pojo.RequestMessage;
import order.service.producer.AMQPProducer;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {
	
	@Autowired
	AMQPProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		RequestMessage req=new RequestMessage();
		
		Order order=new Order();
		order.setOrderId(123);
		order.setOrderName("samsung");
		
		req.setOrder(order);
		req.setType("order");
		
		producer.sendMessage(req);
		
		Thread.sleep(1000);
		
		req=new RequestMessage();
		
		Product product=new Product();
		product.setName("spring");
		
		req.setType("product");
		req.setProduct(product);
		
		producer.sendMessage(req);
		
////		String str=new Gson().toJson(message);
////		producer.sendMessage(str);
//		
////		Product product=new Product();
////		product.setName("spring");
////		
////		message.setObj(product);
////		message.setType("product");
////		
////		str=new Gson().toJson(message);
////		producer.sendMessage(str);
	}

}
