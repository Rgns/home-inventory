package com.rg.homeinventory.messages;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class RabbitMqConfig {


    // queues

    @Bean
    Queue electronicsQueue(){
        return new Queue("Electronic");
    }

    @Bean
    Queue garmentsQueue(){
        return new Queue("Garments");
    }

    @Bean
    Queue foodQueue(){
        return new Queue("Food");
    }


    // exchanges

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    FanoutExchange fanOutexchange(){
        return new FanoutExchange("fanOutExchange");
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange("HeaderExchange");
    }


    // Fanout Exchange binding will all queues

    @Bean
    public Binding bindingf(Queue electronicsQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(electronicsQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingf2(Queue garmentsQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(garmentsQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingf3(Queue foodQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(foodQueue).to(fanoutExchange);
    }


    // Direct Exchange binding will all queues

    @Bean
    public Binding binding(Queue electronicsQueue, DirectExchange directExchange){
        return BindingBuilder.bind(electronicsQueue).to(directExchange).with("electronics");
    }

    @Bean
    public Binding binding2(Queue garmentsQueue, DirectExchange directExchange){
        return BindingBuilder.bind(garmentsQueue).to(directExchange).with("garments");
    }

    @Bean
    public Binding binding3(Queue foodQueue, DirectExchange directExchange){
        return BindingBuilder.bind(foodQueue).to(directExchange).with("food");
    }




    // Topic Exchange binding will all queues

    @Bean
    public Binding topicBinding(Queue electronicsQueue, HeadersExchange headersExchange){
        HashMap<String,Object> map = new HashMap<>();
        map.put("value1","electronics");
        map.put("value2","garments");

        return BindingBuilder.bind(electronicsQueue).to(headersExchange).whereAny(map).match();
    }

//    @Bean
//    public Binding topicBinding2(Queue garmentsQueue, HeadersExchange headersExchange){
//        return BindingBuilder.bind(garmentsQueue).to(headersExchange).with("*.garments.*");
//    }
//
//    @Bean
//    public Binding topicBinding3(Queue foodQueue, HeadersExchange headersExchange){
//        return BindingBuilder.bind(foodQueue).to(headersExchange).with("#.food");
//    }


    // Headers Exchange binding will all queues

    @Bean
    public Binding headerBinding(Queue electronicsQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(electronicsQueue).to(topicExchange).with("*.electronics.*");
    }

    @Bean
    public Binding headerBinding2(Queue garmentsQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(garmentsQueue).to(topicExchange).with("*.garments.*");
    }

    @Bean
    public Binding headerBinding3(Queue foodQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(foodQueue).to(topicExchange).with("#.food");
    }








    @Bean
    public MessageConverter converter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;


    }
}
