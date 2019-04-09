package fr.pantheonsorbonne.entities;

import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Entity
@Table
public class Verifier implements Serializable{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private int score;
    private ArrayList<String> badges;
 
    private ArrayList<Task> tasks;


    //Constructors
    public Verifier() {
    }
    
    public Verifier(String name, int score, ArrayList<String> badges) {
        this.name = name;
        this.score=score;
        this.badges= badges;
    }

    public Verifier(int id, String names) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}