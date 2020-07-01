package com.codegym.services.furamaService;

import com.codegym.models.rentalService.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {
    Page<Room> getAllRoomPaging(Pageable pageable);

    void saveRoom(Room room);

    void deleteRoomById(String id);

    Room getRoomById(String id);
}
