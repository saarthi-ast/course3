package com.udacity.course3.services;

import com.udacity.course3.data.dto.RecipientAndPrice;
import com.udacity.course3.data.entities.Delivery;
import com.udacity.course3.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
   @Autowired
   DeliveryRepository deliveryRepository;

   public Long save(Delivery delivery) {
       delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
       deliveryRepository.persist(delivery);
       return delivery.getId();
   }

    public List<Delivery> findDeliveryByName(String name) {
       return deliveryRepository.findDeliveriesByName(name);
    }

    public RecipientAndPrice getRecipientAndPrice(Long deliveryId) {
       return deliveryRepository.getRecipientAndPrice(deliveryId);
    }
}