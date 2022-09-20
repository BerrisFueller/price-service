package com.example.priceservice.configuration;


import com.example.priceservice.consumer.PriceConsumer;
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
    private String price_key;


    @Value("${queue.price}")
    private String price_queue;


    @Value("${xchange.name}")
    private String exchangeName;

    @Bean
    PriceConsumer priceConsumer() {
        return new PriceConsumer();
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(Queue priceQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(priceQueue).to(directExchange).with(price_key);
    }

    @Bean
    public Queue queue() {
        return new Queue(price_queue);
    }
}