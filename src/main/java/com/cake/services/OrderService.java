package com.cake.services;

import com.cake.entities.Order;
import com.cake.exceptions.CustomException;
import com.cake.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepo;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepo = orderRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = null;

        try {
            orders = orderRepo.findAll();
        } catch (Exception e) {
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return orders;
    }

    public Order getOrderById(long id) {
        Optional<Order> order = null;

        try {
            order = orderRepo.findById(id);
        } catch (Exception e) {
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return order.isPresent() ? order.get() : null;
    }

    public List<Order> getOrderByStatus(String status) {
        List<Order> orders = null;

        try {
            orders = orderRepo.findByStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return orders;
    }

    public Order insertOrder(Order order) {

        try {
            order = orderRepo.saveAndFlush(order);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("This order already exist.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("A problem happened while registering the order", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return order;
    }

    public Order updateOrder(Order order) {
        try {
            Optional<Order> orderOp = orderRepo.findById(order.getId());
            if(!orderOp.isPresent()) throw new CustomException("This order does not exist.", HttpStatus.BAD_REQUEST);
            order.set_createdAt(orderOp.get().get_createdAt());
            order = orderRepo.saveAndFlush(order);
        } catch (CustomException e) {
            throw e;
        } catch (DataIntegrityViolationException e) {
//            e.printStackTrace();
            throw new CustomException("Data Integrity violation.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new CustomException("A problem happened while registering the order", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return order;

    }

}
