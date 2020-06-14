package com.codegym.services.Implement;

import com.codegym.models.Produce;
import com.codegym.repository.ProduceRepository;
import com.codegym.services.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Qualifier("ProduceRepository")
    @Autowired
    ProduceRepository produceRepository;

    @Override
    public List<Produce> getAll() {
        return produceRepository.getAll();
    }

    @Override
    public void addProduce(Produce produce) {
        produceRepository.addProduce(produce);
    }

    @Override
    public void editProduce(Integer id, String name, String price) {
        produceRepository.editProduce(id, name, price);
    }

    @Override
    public void deleteProduce(Integer id) {
         produceRepository.deleteProduce(id);
    }

    @Override
    public Produce getByIdProduce(Integer id) {
        return produceRepository.getByIdProduce(id);
    }
}
