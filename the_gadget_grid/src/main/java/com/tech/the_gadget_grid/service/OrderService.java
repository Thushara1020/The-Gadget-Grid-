package com.tech.the_gadget_grid.service;

import com.tech.the_gadget_grid.entity.Order;
import com.tech.the_gadget_grid.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_UserId(userId);
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setOrderStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
}