package com.codegym.repository.implement;

import com.codegym.models.Produce;
import com.codegym.repository.ProduceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "ProduceRepo")
public class ProduceRepositoryImpl implements ProduceRepository {

    private static Map<Integer, Produce> produceList = new HashMap<>();

    static {
        produceList.put(1, new Produce(1, "iphone", "1000"));
        produceList.put(2, new Produce(2, "samsung", "500"));
        produceList.put(3, new Produce(3, "nokia", "499"));
    }

    @Override
    public List<Produce> getAll() {
        return new ArrayList<>(produceList.values());
    }

    @Override
    public void editProduce(Integer key, Integer Id, String name, String price) {
        produceList.put(key, new Produce(Id, name, price));
    }

    @Override
    public void deleteProduce(Integer Id) {
        produceList.remove(Id);
    }

    @Override
    public void addProduce(Integer key, Integer Id, String name, String price) {
        produceList.put(key, new Produce(Id, name, price));
    }

    @Override
    public Produce findById(Integer key) {
        return produceList.get(key);
    }
}
