package com.codegym.services.furamaService;

import com.codegym.models.rentalService.AccompaniedService;

import java.util.List;

public interface AccompaniedService_Service {
    void saveAccompaniedService(AccompaniedService accompaniedService);

    List<AccompaniedService> getAllAccompaniedService();

    void deleteAccompaniedServiceById(String id);

    AccompaniedService getAccompaniedServiceById(String id);
}
