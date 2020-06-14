package com.codegym.repository;

import com.codegym.models.Produce;

import java.util.List;

public interface ProduceRepository {
       List<Produce> getAll();
       void addProduce(Produce produce);
       void editProduce(Integer id, String name, String price);
       void deleteProduce(Integer id);
       Produce getByIdProduce(Integer id);
}
