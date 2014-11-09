package fr.ujf.iterator.monitor;

public enum State {
	DoHasNext("DoHasNext"), DoNext("DoNext"), Error("Error"), NotStarted("NotStarted");
	
	private String name;
	State (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
