//package com.sports.cricket.Services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducer {
//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;
//
//    public void sendMsgToTopic(String message){
//        kafkaTemplate.send("my_Topic",message);
//    }
//}
