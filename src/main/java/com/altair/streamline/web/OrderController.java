package com.altair.streamline.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altair.streamline.dao.OrderDAO;
import com.altair.streamline.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    public String testController() {
        logger.info("testController endpoint was called");
        return "OrderController is working!";
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderDAO orderDAO) {
        logger.info("CreateOrder endpoint was called with orderDAO: {}", orderDAO);
        orderService.createOrder(orderDAO);
        return "OrderController is working!";
    }
}