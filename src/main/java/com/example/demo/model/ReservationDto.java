package com.example.demo.model;

import com.example.demo.persistance.entity.Reservation;
import com.example.demo.persistance.entity.Tables;
import com.example.demo.persistance.entity.Users;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.LocalTime;


public class ReservationDto {

    private Long id;

    private Users users;

    private Tables tables;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime startTime;

    @DateTimeFormat (iso = DateTimeFormat.ISO.TIME)
    private LocalTime endTime;

    private String status;

    public ReservationDto(Long id, Users users, Tables tables, LocalDate reservDate, LocalTime startTime, LocalTime endTime, String status) {
        this.id = id;
        this.users = users;
        this.tables = tables;
        this.reservDate = reservDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public ReservationDto() {
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", users=" + users +
                ", tables=" + tables +
                ", reservDate=" + reservDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate reservDate) {
        this.reservDate = reservDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation reservation() {
        return new Reservation(id, users, tables,reservDate, startTime, endTime, status);
    }
}
