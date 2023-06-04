package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrder();
    List<Order> findAllByRequirement(LocalDateTime createDate);
    void updateOrder(Order Order);
    void removeOrderById(Long id);
    Optional<Order> getOrderById(Long id);
    boolean saveBill(OrderDTO dto);
}
