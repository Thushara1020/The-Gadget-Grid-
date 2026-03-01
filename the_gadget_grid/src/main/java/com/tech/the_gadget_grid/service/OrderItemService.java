package com.tech.the_gadget_grid.service;

import com.tech.the_gadget_grid.entity.OrderItem;
import com.tech.the_gadget_grid.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrder_OrderId(orderId);
    }

    // save method එක
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}