package com.lvl80.types;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Players")
public class Player implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Salary")
    private int salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Teams_Id")
    private Team team;

    public Player() {
    }

    public Player(String name, int salary, Team team) {
        this.name = name;
        this.salary = salary;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && salary == player.salary && Objects.equals(name, player.name) && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, team);
    }
}
