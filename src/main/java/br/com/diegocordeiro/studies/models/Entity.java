package br.com.diegocordeiro.studies.models;

public class Entity {

    private String uuid;

    public Entity(){

    }
    public Entity(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {

        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
