package com.groupName.artifactName.code.controllers;

import com.groupName.artifactName.code.OrderRequest;
import com.groupName.artifactName.code.models.Order;
import com.groupName.artifactName.code.models.Soldier;
import com.groupName.artifactName.code.service.OrderService;
import com.groupName.artifactName.code.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody Order order) {
//        orderService.create(order);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
        @PostMapping
    public ResponseEntity<?> giveOrder(@RequestBody OrderRequest orderRequest) {
      boolean is_ok =   orderService.giveOrder(orderRequest.getFamilyName(), orderRequest.getOrderID());
      if (is_ok){
          return new ResponseEntity<>(HttpStatus.OK);
      }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Order>> read() {
        final List<Order> orders = orderService.readAll();
        for (Order order:
             orders) {
            order.setFamily(orderService.findFamilyByDon(order.getDon()));

        }
        return orders != null &&  !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dons/{id}")
    public ResponseEntity<Order> read(@PathVariable(name = "id") int id) {
        final Order order = orderService.read(id);

        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/dons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Order order) {
        final boolean updated = orderService.update(order, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/dons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = orderService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
