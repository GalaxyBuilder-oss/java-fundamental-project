package com.salim.systempub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salim.systempub.entities.pasim.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{
    
}
