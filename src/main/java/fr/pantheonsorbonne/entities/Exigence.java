package fr.pantheonsorbonne.entities;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table
public class Exigence{

	private int id;
    private String text;
    private ArrayList<Feature> features;
    private DefectType dt;
   
    //Contructors
    public Exigence() {
   
    }
   
    public Exigence(String text) {
    	this.text = text;
    }
    
    public Exigence(String text, ArrayList<Boolean> rv,ArrayList<Report> reports) {
    	this.text = text;
    	this.features = new ArrayList<Feature>(5);
        this.features.get(0).setFc(Feature_Content.Ambiguity.toString());
        this.features.get(1).setFc(Feature_Content.Overspecification.toString());
        this.features.get(2).setFc(Feature_Content.Underspecification.toString());
        this.features.get(3).setFc(Feature_Content.Inconsistency.toString());
        this.features.get(4).setFc(Feature_Content.Infeasibility.toString());
        for (int i = 0; i < 5; i++) {
			this.features.get(i).setFv(rv.get(i));
			this.features.get(i).setReport(reports.get(i));
		}
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}

	public DefectType getDt() {
		return dt;
	}

	public void setDt(DefectType dt) {
		this.dt = dt;
	}

    
}