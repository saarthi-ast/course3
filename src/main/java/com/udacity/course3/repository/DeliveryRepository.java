package com.udacity.course3.repository;

import com.udacity.course3.data.dto.RecipientAndPrice;
import com.udacity.course3.data.entities.Delivery;
import com.udacity.course3.data.entities.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> deliveries = entityManager.createNamedQuery("delivery.findByName",Delivery.class);
        deliveries.setParameter("name", name);
        return deliveries.getResultList();
    }

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    public RecipientAndPrice getRecipientAndPrice(Long id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> criteria = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = criteria.from(Plant.class);
        criteria.select(cb.construct(
                RecipientAndPrice.class,
                root.get("delivery").get("name"),
                root.get("price"))).where(cb.equal(root.get("delivery").get("id"),id));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
