package com.codegym.services.furamaService.impl;

import com.codegym.models.rentalService.Room;
import com.codegym.repositories.serviceRepo.RoomRepository;
import com.codegym.services.furamaService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Page<Room> getAllRoomPaging(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public void saveRoom(Room room) {
        room.setId(geneIdForEachRoom());
        roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(String id) {
        roomRepository.deleteRoomById(id);
    }

    @Override
    public Room getRoomById(String id) {
        return roomRepository.getRoomById(id);
    }

    @Override
    public void editRoom(Room room) {
        roomRepository.save(room);
    }

    private String geneIdForEachRoom() {
        Integer idGene = 0;
        idGene = (int) (Math.random() * 8999 + 1000);
        if (roomRepository.existsRoomById("RO-" + (idGene))) {
            geneIdForEachRoom();
        }
        return "RO-" + (idGene);
    }
}
