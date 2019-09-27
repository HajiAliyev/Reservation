package com.example.demo.persistance.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "tables",cascade = CascadeType.REMOVE /*fetch = FetchType.LAZY*/)
//    private List<Reservation> reservationList;

    private  Long type;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    public Tables(Long id,Long type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Tables() {
    }


}
