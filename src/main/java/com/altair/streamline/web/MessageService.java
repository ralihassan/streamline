package com.altair.streamline.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.altair.streamline.dao.OrderDAO;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @KafkaListener(topics = "orders", groupId = "order_group")
    public void listen(OrderDAO order) {
        logger.info("Received order: {}", order.getCustomerName());
        // Process the order as needed
    }

}
