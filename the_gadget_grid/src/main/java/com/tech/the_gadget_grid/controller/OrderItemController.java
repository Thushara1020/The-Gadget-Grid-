package com.tech.the_gadget_grid.controller;

import com.tech.the_gadget_grid.entity.OrderItem;
import com.tech.the_gadget_grid.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getItemsByOrder(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrderId(orderId);
    }

    @PostMapping("/add")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }
}