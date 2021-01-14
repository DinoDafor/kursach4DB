package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Order;
import com.groupName.artifactName.code.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order read(int id) {
        return orderRepository.getOne(id);
    }

    @Override
    public boolean update(Order order, int id) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            orderRepository.save(order);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean giveOrder(String family, Integer orderID) {
       Integer don_id =  orderRepository.findDonOffFamily(family);
        return  orderRepository.giveOrder(don_id, orderID, false );

    }
}
