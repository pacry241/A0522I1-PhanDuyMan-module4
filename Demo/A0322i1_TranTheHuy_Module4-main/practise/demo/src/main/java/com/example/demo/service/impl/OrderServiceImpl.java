package com.example.demo.service.impl;


import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository detailRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    } //findAll

    @Override
    public List<Order> findAllByRequirement(LocalDateTime createDate) {
        return orderRepository.findAllByRequirement(createDate);
    }

    @Override
    public void updateOrder(Order Order) {
        orderRepository.save(Order);
    } //add or update (tuy vao pri-key)

    @Override
    public void removeOrderById(Long id) {
        orderRepository.deleteById(id);
    }//delete dua vao pri-key

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    } //search theo id

    @Override
    public boolean saveBill(OrderDTO orderDTO) {
        User currentUser = userRepository.findById(orderDTO.getUserId()).orElse(null);
        if (currentUser == null) {
            return false;
        }
        //order: dto > entity
        Order entity = new Order();
        entity.setEmail(orderDTO.getEmail());
        entity.setPhone(orderDTO.getPhone());
        entity.setRecipientName(orderDTO.getRecipientName());
        entity.setStreet(orderDTO.getStreet());
        entity.setDistrict(orderDTO.getDistrict());
        entity.setCity(orderDTO.getCity());
        entity.setCountryName(orderDTO.getCountryName());
        entity.setPostalCode(orderDTO.getPostalCode());
        entity.setTotal(orderDTO.getTotal());
        entity.setNote(orderDTO.getNote());
        entity.setCreateDate(orderDTO.getCreateDate());

        Order order = orderRepository.save(entity);

        //convert list product duplicated into map
        Map<Long, List<Product>> distinctProduct = orderDTO.getCart()
                .stream()
                .collect(
                        Collectors.groupingBy(Product::getId)
                );
        //create list detail of order
        List<OrderDetail> details = new ArrayList<>();
        try {
            distinctProduct.entrySet().forEach(item -> {
                OrderDetail detail = new OrderDetail();
                detail.setPrice(item.getValue().get(0).getPrice());
                detail.setQuantity(item.getValue().size());
                detail.setOrder(order);
                detail.setProduct(item.getValue().get(0));

                details.add(detail);
            });
        } catch (Exception e) {
            //return
            return false;
        }
        //save into db
        //
        //save order first then orderdetail.setorder()
        detailRepository.saveAll(details);
        //okey
        //clear cart
        return true;
    }//not done yet
}
