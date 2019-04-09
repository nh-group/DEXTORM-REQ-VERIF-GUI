package fr.pantheonsorbonne.entities;

import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class  Task{

     //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private  int task_id;
     @Column
     private Verifier tester;
     private ArrayList<Report> reports;


    //Contructors
    public Task() {

    }
    public Task(Verifier tester, ArrayList<Report> reports) {
        this.tester = tester;
        this.reports = reports;
    }

    //Getters & setters

    public Verifier getTester() {
        return tester;
    }

    public void setTester(Verifier tester) {
        this.tester = tester;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
}