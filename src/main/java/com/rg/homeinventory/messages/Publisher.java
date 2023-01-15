package com.rg.homeinventory.messages;

import lombok.*;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/message")
public class Publisher {


    @Autowired
    RabbitTemplate rabbitTemplate;


    @PostMapping("/")
    public String publishMessage(@RequestBody MyMessage msg){

       // String mymessage = "Ram is good boy";
        if(msg.getExchangeName().equals("HeaderExchange")){
            MessageProperties properties = new MessageProperties();
            properties.setHeader("value1",msg.getCustomMessage().getMsg());
            properties.setHeader("value2",msg.getCustomMessage().getData());

            MessageConverter messageConverter = new SimpleMessageConverter();
            Message message = messageConverter.toMessage(msg.getCustomMessage(), properties);
            rabbitTemplate.send(msg.getExchangeName(),"",message);
            return "SUCCESS";
        }




        rabbitTemplate.convertAndSend(msg.getExchangeName(),msg.getRoutingKey(),msg.getCustomMessage());

        return "SUCCESS";
    }


//    @RabbitListener(queues = "Electronic")
//    public void consumer(byte[] msg) throws IOException, ClassNotFoundException {
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(msg);
//        ObjectInput objectInput = new ObjectInputStream(bis);
//        CustomMessage message = (CustomMessage) objectInput.readObject();
//        objectInput.close();
//        bis.close();
//
//        System.out.println(message);
//        if(message.getMsg() != null){
//            System.out.println(message.getMsg());
//        }
//        System.out.println("I am Electronic  Queue "  + " with data " );
//    }

//    @RabbitListener(queues = "Food")
//    public void consumer2(CustomMessage msg){
//        System.out.println("I am Food Queue " + msg.getMsg() + " with data " + msg.getData());
//    }
//
//    @RabbitListener(queues = "Garments")
//    public void consumer3(CustomMessage msg){
//        System.out.println("I am Garments Queue" + msg.getMsg() + " with data " + msg.getData());
//    }


}



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
class MyMessage{
    private CustomMessage customMessage;
    private String routingKey;
    private String exchangeName;
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
class CustomMessage implements Serializable {
    private String msg;
    private String data;
}