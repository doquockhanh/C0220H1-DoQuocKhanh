package com.codegym.services;

import com.codegym.models.Produce;

import java.util.List;

public interface ProduceService {
    List<Produce> getAll();
    void addProduce(Produce produce);
    void editProduce(Integer id, String name, String price);
    void deleteProduce(Integer id);
    Produce getByIdProduce(Integer id);
}
