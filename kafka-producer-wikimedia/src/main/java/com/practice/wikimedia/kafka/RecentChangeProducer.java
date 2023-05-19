package com.practice.wikimedia.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.practice.wikimedia.WikimediaChangeHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class RecentChangeProducer {
    KafkaTemplate<String, String > kafkaTemplate;

    public RecentChangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recentChange";
        EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource
                .Builder(eventHandler, URI.create(url))
                .build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
