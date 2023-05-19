package com.practice.wikimedia;

import com.practice.wikimedia.entity.WikimediaRecentChange;
import com.practice.wikimedia.repository.WikimediaRecentChangeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaDatabaseConsumer {

    @Autowired
    WikimediaRecentChangeRepository repository;

    @KafkaListener(topics = "wikimedia_recentChange", groupId = "wikimeidaconsumerGroup")
    public void consumeMessage(Double eventMessage) {
        log.info(eventMessage);
        WikimediaRecentChange wikimediaRecentChange = new WikimediaRecentChange();
        wikimediaRecentChange.setChangeEventData(eventMessage.toString());
        repository.save(wikimediaRecentChange);
    }
}
