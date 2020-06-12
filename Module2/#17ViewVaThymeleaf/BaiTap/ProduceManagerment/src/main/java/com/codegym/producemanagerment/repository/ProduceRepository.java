package com.codegym.producemanagerment.repository;

import com.codegym.producemanagerment.models.Produce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduceRepository extends JpaRepository<Produce, Long> {

    List<Produce> getAll();
    void deleteProduce(Integer Id);
    void updateProduce(Integer Id);
    void allNewProduce(Produce produce);
}
