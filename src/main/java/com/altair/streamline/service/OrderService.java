package com.altair.streamline.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.altair.streamline.dao.OrderDAO;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private KafkaTemplate<String, OrderDAO> kafkaTemplate;

    private static final String TOPIC = "orders";

    public void createOrder(OrderDAO orderDAO) {
        kafkaTemplate.send(TOPIC, orderDAO);
    }

    // @KafkaListener(topics = TOPIC, groupId = "order_group")
    // public void listen(OrderDAO order) {
    // logger.info("Received order: {}", order);
    // // Process the order as needed
    // }

}
