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

    @Autowired
    ProduceRepository produceRepository;

    @Override
    public List<Produce> getAll() {
        return produceRepository.findAll();
    }

    @Override
    public void editProduce(Produce produce) {
        produceRepository.save(produce);
    }

    @Override
    public void deleteProduce(Integer Id) {
        produceRepository.deleteById(Id);
    }

    @Override
    public void addProduce(Produce produce) {
        produceRepository.save(produce);
    }

    @Override
    public Produce findById(Integer id) {
        return produceRepository.findById(id).orElse(null);
    }

}
