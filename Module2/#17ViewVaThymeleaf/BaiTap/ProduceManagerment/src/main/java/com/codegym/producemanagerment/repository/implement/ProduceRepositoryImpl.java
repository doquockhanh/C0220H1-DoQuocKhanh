package com.codegym.producemanagerment.repository.implement;

import com.codegym.producemanagerment.models.Produce;
import com.codegym.producemanagerment.repository.ProduceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "ProduceManagement")
@Transactional
public class ProduceRepositoryImpl implements JpaRepository<Produce, Long> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Produce> getAll() {
        TypedQuery<Produce> typedQuery = entityManager.createQuery(
                "select s from Produce s", Produce.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteProduce(Integer Id) {

    }

    @Override
    public void updateProduce(Integer Id) {

    }

    @Override
    public void allNewProduce(Produce produce) {

    }
}
