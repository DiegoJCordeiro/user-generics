package br.com.diegocordeiro.studies.models;

public class User extends Entity {

    private String fullName;
    private String nickname;
    private Integer age;
    private Role role;

    public User() {
        super();
    }

    public User(String uuid, String fullName, String nickname, Integer age, Role role) {
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
                "uuid='" + this.getUuid() + "'" +
                ", fullName='" + this.getFullName() + '\'' +
                ", nickname='" + this.getNickname() + '\'' +
                ", age=" + this.getAge() +
                ", role=" + this.getRole() +
                '}';
    }
}
