package com.algaworks.algasensors.temperature.processing.infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FANOUT_EXCHANGE = "temperature-processing.temperature-received.v1.e";

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(final ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    FanoutExchange exchange(){
        return ExchangeBuilder
                .fanoutExchange(FANOUT_EXCHANGE)
                .build();
    }

}
