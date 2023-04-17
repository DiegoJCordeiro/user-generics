package br.com.diegocordeiro.studies.dto;

import br.com.diegocordeiro.studies.models.Role;

public class UserDTO extends DTO {

    private String fullName;
    private String nickname;
    private Integer age;
    private Role role;

    public UserDTO() {
        super(null);
    }
    public UserDTO(String uuid, String fullName, String nickname, Integer age, Role role) {
        super(uuid);
        this.fullName = fullName;
        this.nickname = nickname;
        this.age = age;
        this.role = role;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Integer getAge() {
        return this.age;
    }

    public Role getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + this.getFullName() + '\'' +
                ", nickname='" + this.getNickname() + '\'' +
                ", age=" + this.getAge() +
                ", role=" + this.getRole() +
                '}';
    }
}
