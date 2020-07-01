package com.codegym.services.employee;

import com.codegym.models.employee.Literacy;

import java.util.List;

public interface LiteracyService {

    void saveLateral(Literacy literacy);

    List<Literacy> getAllLiteracy();

    void deleteLiteracy(Integer id);

    Literacy getLiteracyById(Integer id);
}
