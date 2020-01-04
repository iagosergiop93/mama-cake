package com.cake.controllers;

import com.cake.dtos.OrderDto;
import com.cake.entities.Order;
import com.cake.exceptions.CustomException;
import com.cake.services.OrderService;
import com.cake.utils.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping
    @RequestMapping("/id/{id}")
    public Order getOrderById(@PathVariable long id) {
        if(id == 0) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return orderService.getOrderById(id);
    }

    @GetMapping
    @RequestMapping("/status/{status}")
    public List<Order> getOrderByStatus(@PathVariable String status) {
        if(status == null || status.equals("")) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return orderService.getOrderByStatus(status.toUpperCase());
    }

    @PostMapping
    public Order insertOrder(@RequestBody OrderDto orderDto) {
        if(orderDto == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return orderService.insertOrder(new Order(orderDto));
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        if(order == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return orderService.updateOrder(order);
    }

}
