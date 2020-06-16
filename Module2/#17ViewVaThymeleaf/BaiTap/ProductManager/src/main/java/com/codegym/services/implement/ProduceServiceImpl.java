package com.codegym.services.implement;

import com.codegym.models.Produce;
import com.codegym.repository.ProduceRepository;
import com.codegym.services.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceServiceImpl implements ProduceService {
    @Qualifier("ProduceRepo")
    @Autowired
    ProduceRepository produceRepository;

    @Override
    public List<Produce> getAll() {
        return produceRepository.getAll();
    }

    @Override
    public void editProduce(Integer key, Integer Id, String name, String price) {
        produceRepository.editProduce(key, Id, name, price);
    }

    @Override
    public void deleteProduce(Integer Id) {
        produceRepository.deleteProduce(Id);
    }

    @Override
    public void addProduce(Integer key, Integer Id, String name, String price) {
        produceRepository.addProduce(key, Id, name, price);
    }

    @Override
    public Produce findById(Integer key) {
        return produceRepository.findById(key);
    }

}
