package sushil.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;


public class WikiEventHandler  implements EventHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiEventHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikiEventHandler(KafkaTemplate<String, String> kafkaTemplate, String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data -> %s", messageEvent.getData()));

        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onComment(String s) throws Exception {

    }
    
}
