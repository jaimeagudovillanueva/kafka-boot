package es.jaime.kafkaboot.controller;

import es.jaime.kafkaboot.pojo.User;
import es.jaime.kafkaboot.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController
{
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message)
    {
        this.producerService.sendMessage(message);
    }

    @PostMapping(value = "/user")
    public void sendUserToKafkaTopic(@RequestBody User user)
    {
        this.producerService.saveCreateUserLog(user);
    }
}
