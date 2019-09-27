package com.example.demo.persistance.repository;

import com.example.demo.model.TablesUtilDto;
import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface TablesRepository extends JpaRepository<Tables, Long>, CrudRepository<Tables, Long> {


//    @Transactional
//    @Modifying





//    @Query(value = "select  t.id, t.type, t.description,  r.id , r.user_id, r.table_id, r.start_time, r.end_time, r.status, r.date from tables t " +
//            " LEFT JOIN(select res from Reservation res where   res.start_time >=: start_time AND res.end_time <=:end_time AND res.date =: date  ) r " +
//            "ON t.id = r.table_id WHERE t.type=2 order by t.id ")
//    public List<TablesUtilDto> findByParameter2(@Param("start_time")LocalTime in_start_time, @Param("end_time")LocalTime in_end_time, @Param("date")LocalDate in_date);
//
//    @Query(value = "select  t.id, t.type, t.description,  r.id , r.user_id, r.table_id, r.start_time, r.end_time, r.status, r.date from tables t " +
//            " LEFT JOIN(select res from Reservation res where   res.start_time >=: start_time AND res.end_time <=:end_time AND res.date =: date  ) r " +
//            "ON t.id = r.table_id WHERE t.type=6 order by t.id ")
//    public List<TablesUtilDto> findByParameter6(@Param("start_time")LocalTime in_start_time, @Param("end_time")LocalTime in_end_time, @Param("date")LocalDate in_date);


    @Query(value = "select t from Tables t where t.type =:type ")
    public List<Tables> findByType(@Param("type") Long in_type);


//    @Query(value = "select t from Tables t where t.id =:id ")
//    public Optional<Tables> findById(@Param("id") Long in_id);

}
