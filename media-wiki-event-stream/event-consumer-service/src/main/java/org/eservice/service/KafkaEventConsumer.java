package org.eservice.service;

import org.eservice.entity.WikimediaData;
import org.eservice.repository.KafkaConsumerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventConsumer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaEventConsumer.class);

    private KafkaConsumerRepository kafkaConsumerRepository;

    public KafkaEventConsumer (KafkaConsumerRepository kafkaConsumerRepository){
        this.kafkaConsumerRepository = kafkaConsumerRepository;
    }

    @KafkaListener(
            topics = {"wiki_media_recent_changes"},
            groupId = "myGroup"
    )
    public void consume(String message){
        LOGGER.info(String.format("recent changes subscribed ->>", message));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(message);

        kafkaConsumerRepository.save(wikimediaData);
    }

}
