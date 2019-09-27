package com.example.demo.model;

public class TableInfoDto {

    public TableInfoDto(TablesDto tablesDto, String status) {
        this.tablesDto = tablesDto;
        this.status = status;
    }

    public TableInfoDto() {
    }

    private TablesDto tablesDto;
    private String status;

    public TablesDto getTablesDto() {
        return tablesDto;
    }

    public void setTablesDto(TablesDto tablesDto) {
        this.tablesDto = tablesDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TableInfoDto{" +
                "tablesDto=" + tablesDto +
                ", status='" + status + '\'' +
                '}';
    }
}
