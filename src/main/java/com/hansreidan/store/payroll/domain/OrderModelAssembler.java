package com.hansreidan.store.payroll.domain;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.hansreidan.store.payroll.controllers.OrderController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if(order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderController.class).deleteOrder(order.getId())).withRel("cancel"));

            orderModel.add(linkTo(methodOn(OrderController.class).completeOrder(order.getId())).withRel("complete"));
        }
        return orderModel;
    }
}
