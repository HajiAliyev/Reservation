package com.example.demo.model;

import java.util.List;

public class TablesUtilDto {

    public TablesUtilDto(List<TableInfoDto> tableInfoDtoList) {
        this.tableInfoDtoList = tableInfoDtoList;
    }

    public TablesUtilDto() {
    }
    private List<TableInfoDto> tableInfoDtoList;

    public List<TableInfoDto> getTableInfoDtoList() {
        return tableInfoDtoList;
    }

    public void setTableInfoDtoList(List<TableInfoDto> tableInfoDtoList) {
        this.tableInfoDtoList = tableInfoDtoList;
    }
}
