package com.sksmccorp.consumertwo.service;

import com.sksmccorp.consumertwo.KafkaConfig.KafkaAccess;
import lombok.Data;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Data
public class ConsumerService {

//    private final KafkaConsumer<String, String> kafkaConsumer;
    private final Consumer<String, String> kafkaConsumer;
    private static final String autoOffsetRest = "earliest";
    private static final String bootStrapServer = "pkc-9q8rv.ap-south-2.aws.confluent.cloud:9092";
    private static final String schemaResgistryUrl = "https://psrc-mw2k1.us-east-2.aws.confluent.cloud";
    private static final String consumerGroupId = "Consumer1-heyconfluent";
    private static final boolean keepConsuming = true;
    private static final String topic_0 = "topic_0";

    public ConsumerService() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetRest);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty("ssl.endpoint.identification.algorithm", "https");
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=IE2YQER62J2Z4GOL password=jPfrFAQX6ThQB12cqwJX9XjMspzsYwuvapWhG9lgNtsDbLzC1XUsC59XYW0brgP8;");
        properties.setProperty("security.protocol", "SASL_SSL");

        kafkaConsumer = new KafkaConsumer<>(properties);
        //kafkaConsumer = new KafkaAccess().getConsumerFactory(properties).createConsumer();
        kafkaConsumer.subscribe(List.of(topic_0));
    }

    public void consume() {
        while(keepConsuming) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
            consumerRecords.iterator().forEachRemaining(item -> {
                System.out.println("Message: " + item.value());
                System.out.println("Count: " + consumerRecords.count());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            //kafkaConsumer.commitSync();
        }
    }
}
