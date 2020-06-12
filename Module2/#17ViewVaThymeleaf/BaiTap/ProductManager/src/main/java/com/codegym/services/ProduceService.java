package com.codegym.services;

import com.codegym.models.Produce;

import java.util.List;

public interface ProduceService {
    List<Produce> getAll();
    void editProduce(Integer key, Integer Id, String name, String price);
    void deleteProduce(Integer Id);
    void addProduce(Integer key, Integer Id, String name, String price);
    Produce findById(Integer key);
}
