package fr.pantheonsorbonne.entities;


import javax.persistence.*;


@Entity
@Table
public class Report{

    //Attributes
    private int report_id;
    private Exigence req;
    private DefectType dt;


    //Contructors

    public Report() {
    }

    public Report(int report_id, Exigence req, DefectType dt) {
        this.report_id = report_id;
        this.req = req;
        this.dt = dt;
    }

    //Getters & setters
    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public Exigence getReq() {
        return req;
    }

    public void setReq(Exigence req) {
        this.req = req;
    }

    public DefectType getDt() {
        return dt;
    }

    public void setDt(DefectType dt) {
        this.dt = dt;
    }

}
