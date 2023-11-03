package com.sksmccorp.consumertwo.KafkaConfig;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaAccess {
    public ConsumerFactory<String, String> getConsumerFactory(Properties properties)
    {
        Map<String, Object> config = new HashMap<>();

        // Adding the Configuration
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "pkc-9q8rv.ap-south-2.aws.confluent.cloud:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,
                "Consumer1-heyconfluent");
        config.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        config.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        config.put("ssl.endpoint.identification.algorithm", "https");
        config.put("sasl.mechanism", "PLAIN");
        config.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=IE2YQER62J2Z4GOL password=jPfrFAQX6ThQB12cqwJX9XjMspzsYwuvapWhG9lgNtsDbLzC1XUsC59XYW0brgP8;");
        config.put("security.protocol", "SASL_SSL");

        return new DefaultKafkaConsumerFactory<>(config);
    }

}
