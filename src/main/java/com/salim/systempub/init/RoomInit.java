package com.salim.systempub.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.salim.systempub.entities.pasim.Room;
import com.salim.systempub.repositories.RoomRepository;

public class RoomInit implements Runnable {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run() {

        List<Room> listRoom = new ArrayList<>();

        // Lantai 2
        listRoom.add(new Room(0L, "Lorong Lantai 2", null));
        listRoom.add(new Room(1L, "2A", null));
        listRoom.add(new Room(2L, "2B", null));
        listRoom.add(new Room(3L, "2C", null));
        listRoom.add(new Room(4L, "2D", null));
        listRoom.add(new Room(5L, "2E", null));
        listRoom.add(new Room(6L, "B.2.1", null));
        listRoom.add(new Room(7L, "B.2.2", null));
        listRoom.add(new Room(8L, "B.2.3", null));
        listRoom.add(new Room(9L, "B.2.4", null));
        listRoom.add(new Room(10L, "B.2.5", null));
        listRoom.add(new Room(11L, "B.2.6", null));

        // Lantai 3
        listRoom.add(new Room(12L, "Lorong Lantai 3", null));
        listRoom.add(new Room(13L, "3B", null));
        listRoom.add(new Room(14L, "B.3.1", null));
        listRoom.add(new Room(15L, "B.3.2", null));
        listRoom.add(new Room(16L, "B.3.3", null));

        // Halaman
        listRoom.add(new Room(17L, "Parkiran Atas", null));
        listRoom.add(new Room(18L, "Parkiran Bawah", null));
        listRoom.add(new Room(19L, "Depan ATM", null));
        listRoom.add(new Room(20L, "Samping Perpustakaan", null));
        listRoom.add(new Room(21L, "Depan Kantin", null));
        listRoom.add(new Room(22L, "Depan Kampus", null));

        if (roomRepository.findAll().isEmpty())
            roomRepository.saveAll(listRoom);
    }

}
