//package com.sports.cricket.Controller;
//
//import com.sports.cricket.Services.KafkaProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kafka/api")
//public class KafkaController {
//
//    @Autowired
//    KafkaProducer kafkaProducer;
//
//    @GetMapping(value = "/producer")
//    public void getMessageFromClient(@RequestParam("message") String message) {
//        kafkaProducer.sendMsgToTopic(message);
//    }
//}
//
