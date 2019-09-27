package com.example.demo.persistance.repository;

import com.example.demo.persistance.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query(value = "select r from Reservation r  where r.reservDate =:reservDate and not  (r.endTime <= :startTime OR r.startTime >= :endTime)")
    public List<Reservation> findByReservDateAndStartTimeAndEndTime(@Param("reservDate") LocalDate in_reservDate, @Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime );
}
