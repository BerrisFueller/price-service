package com.example.priceservice.configuration;


import com.example.priceservice.service.PriceService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${routing-key.price}")
    private String routingKey;


    @Value("${queue.price}")
    private String queueName;


    @Value("${xchange.name}")
    private String exchangeName;

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding (){
        return BindingBuilder.bind(queue()).to(directExchange()).with(routingKey);
    }

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    @Bean
    public PriceService getPriceService(){
        return new PriceService();
    }
}
