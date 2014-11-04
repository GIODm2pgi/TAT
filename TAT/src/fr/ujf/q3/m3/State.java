package fr.ujf.q3.m3;

public enum State {
	DoHasNext("DoHasNext"), DoNext("DoNext"), Error("Error");
	
	private String name;
	State (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
