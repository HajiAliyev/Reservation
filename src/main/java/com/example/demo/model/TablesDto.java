package com.example.demo.model;

import com.example.demo.persistance.entity.Tables;

public class TablesDto {

    private Long id;

    private Long type;

    private String description;

    //getter setter

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


    //toString

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    public TablesDto(Long id, Long type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public TablesDto() {
    }

    public Tables tables (){
        return new Tables(id,type, description );
    }


}
