package com.algaworks.algasensors.temperature.processing.infrastructure.rabbitmq;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    FanoutExchange exchange(){
        return ExchangeBuilder
                .fanoutExchange("temperature-processing.temperature-received.v1.e")
                .build();
    }

}
