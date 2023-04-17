package br.com.diegocordeiro.studies.dto;

public class DTO {

    private String uuid;

    public DTO(String uuid) {
        this.uuid = uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid(){

        return this.uuid;
    }
}
