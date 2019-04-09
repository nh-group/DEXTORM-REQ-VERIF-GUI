package fr.pantheonsorbonne.entities;

public class Feature{
	
	//Attributes
	private int id;
	private String fc;
	private boolean fv;
	private Report report;
	
	
	//Contructor
	public Feature() {
		
	}
	   
	
	//Getters and Setters   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}
	public boolean isFv() {
		return fv;
	}
	public void setFv(boolean fv) {
		this.fv = fv;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	
}
