package org.eservice.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KakfaEventSourceProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KakfaEventSourceProducer (KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final Logger LOGGER =
            LoggerFactory.getLogger(KakfaEventSourceProducer.class);

    public void sendMessage(String message) throws InterruptedException {
        EventHandler wikimediaChangesHandler =
                new WikimediaChangesHandler(kafkaTemplate);

        String Url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource eventSource = new EventSource
                .Builder(wikimediaChangesHandler, URI.create(Url))
                .build();

        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }


}
