package sushil.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import sushil.kafka.consumer.entity.WikiDatabase;
import sushil.kafka.consumer.repository.WikiRepository;


@Service
public class WikiConsumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WikiConsumer.class);

    private WikiRepository dataRepository;

    public WikiConsumer(WikiRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics  = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikiDatabase wikiData = new WikiDatabase();
        wikiData.setWikiEventData(eventMessage);

        dataRepository.save(wikiData);
    }
}
