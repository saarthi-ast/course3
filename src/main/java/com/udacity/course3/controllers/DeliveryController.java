package com.udacity.course3.controllers;

import com.udacity.course3.data.dto.RecipientAndPrice;
import com.udacity.course3.data.entities.Delivery;
import com.udacity.course3.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
   @Autowired
   DeliveryService deliveryService;

   @PostMapping
   public Long scheduleDelivery(@RequestBody Delivery delivery) {
       return deliveryService.save(delivery);
   }

   @GetMapping("/{name}")
   public List<Delivery> findDeliveryByName(@PathVariable(name = "name") String name){
      return deliveryService.findDeliveryByName(name);
   }


   @GetMapping("/details/{deliveryId}")
   public RecipientAndPrice getRecipientAndPrice(@PathVariable Long deliveryId){
      return deliveryService.getRecipientAndPrice(deliveryId);
   }
}