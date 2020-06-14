package com.codegym.repository.implement;

import com.codegym.models.Produce;
import com.codegym.repository.ProduceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "ProduceRepository")
@Transactional
public class ProduceRepo implements ProduceRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Produce> getAll() {

        TypedQuery<Produce> typedQuery = entityManager.createQuery(
                "select p from Produce p", Produce.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void addProduce(Produce produce) {
        entityManager.persist(produce);
    }

    @Override
    public void editProduce(Integer id, String name, String price) {
        Produce editProduce = new Produce(id, name, price);
        entityManager.merge(editProduce);
    }

    @Override
    public void deleteProduce(Integer id) {
         Produce deleteProduce = getByIdProduce(id);
         entityManager.remove(deleteProduce);
    }

    @Override
    public Produce getByIdProduce(Integer id) {
        TypedQuery<Produce> typedQuery = entityManager.createQuery(
                "select p from Produce p where p.id = :id", Produce.class
        );
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }
}
