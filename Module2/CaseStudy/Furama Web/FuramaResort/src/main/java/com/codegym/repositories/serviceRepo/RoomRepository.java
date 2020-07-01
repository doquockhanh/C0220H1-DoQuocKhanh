package com.codegym.repositories.serviceRepo;

import com.codegym.models.rentalService.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
    boolean existsRoomById(String id);

    Room getRoomById(String id);

    void deleteRoomById(String id);
}
