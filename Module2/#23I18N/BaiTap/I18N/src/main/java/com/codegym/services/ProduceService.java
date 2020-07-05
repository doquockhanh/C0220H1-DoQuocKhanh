package com.codegym.services;

import com.codegym.models.Produce;

import java.util.List;

public interface ProduceService {
    List<Produce> getAll();
    void editProduce(Produce produce);
    void deleteProduce(Integer Id);
    void addProduce(Produce produce);
    Produce findById(Integer key);
}
