package com.example.demo.persistance.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @Column(name = "id"  )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //LAZY is important
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;


    @ManyToOne(fetch = FetchType.LAZY) //LAZY is important
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "table_id", nullable = false)
    private Tables tables;

    @Column(name="date")
    private LocalDate reservDate;

    @Column(name="start_time")
    private LocalTime startTime;

    @Column(name="end_time")
    private LocalTime endTime;

    private String status;

    public Reservation(Long id, Users users, Tables tables, LocalDate reservDate, LocalTime startTime, LocalTime endTime, String status) {
        this.id = id;
        this.users = users;
        this.tables = tables;
        this.reservDate = reservDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;

    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" +
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

    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate date) {
        this.reservDate = reservDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
