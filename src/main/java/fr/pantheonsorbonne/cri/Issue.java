package fr.pantheonsorbonne.cri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Issue {
	public int number;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String title;
	public List<String> labels = new ArrayList<>();
	
	public String toString() {
		
		return "<a href='"+this.number+"' >"+this.getTitle()+"</a>";
		
	}

	public Issue(int number, String title, Collection<String> labels) {
		this.number = number;
		this.title = title;
		this.labels.addAll(labels);
	}
}