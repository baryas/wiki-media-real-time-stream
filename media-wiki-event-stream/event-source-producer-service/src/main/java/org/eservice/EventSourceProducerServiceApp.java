package org.eservice;

import org.eservice.service.KakfaEventSourceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSourceProducerServiceApp implements CommandLineRunner {

    private KakfaEventSourceProducer kakfaEventSourceProducer;

    public EventSourceProducerServiceApp(KakfaEventSourceProducer kakfaEventSourceProducer) {
        this.kakfaEventSourceProducer = kakfaEventSourceProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(EventSourceProducerServiceApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        kakfaEventSourceProducer.sendMessage("ok");
    }
}